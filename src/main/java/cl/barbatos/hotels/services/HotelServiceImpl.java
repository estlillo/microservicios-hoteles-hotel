package cl.barbatos.hotels.services;

import java.util.*;

import cl.barbatos.hotels.model.dto.HotelRooms;
import cl.barbatos.hotels.model.dto.Room;
import cl.barbatos.hotels.services.clients.RoomsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.barbatos.hotels.dao.IHotelDao;
import cl.barbatos.hotels.model.Hotel;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;

	@Autowired
	private RestTemplate clientRest;

	@Autowired
	RoomsFeignClient roomsFeignClient;

	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}


	@Override
	public HotelRooms searchHotelRoomsById(Long id) {
		return hotelDao.findById(id)
				.map(hotel -> {
					Map<String, Long> pathVariables = Map.of("id", id);
					Room[] rooms = clientRest.getForObject("http://localhost:8088/roomsByHotelId/{id}", Room[].class, pathVariables);
					HotelRooms hotelRoomsResponse = new HotelRooms();
					hotelRoomsResponse.setHotelId(hotel.getHotelId());
					hotelRoomsResponse.setHotelName(hotel.getHotelName());
					hotelRoomsResponse.setHotelAddress(hotel.getHotelAddress());
					hotelRoomsResponse.setRooms(Arrays.asList(rooms));
					return hotelRoomsResponse;
				})
				.orElse(null);
	}

	@Override
	public HotelRooms searchHotelRoomsByIdFeing(Long id) {
		return hotelDao.findById(id)
				.map(hotel -> {
					List<Room> rooms = roomsFeignClient.searchByHotelId(id);
					HotelRooms hotelRoomsResponse = new HotelRooms();
					hotelRoomsResponse.setHotelId(hotel.getHotelId());
					hotelRoomsResponse.setHotelName(hotel.getHotelName());
					hotelRoomsResponse.setHotelAddress(hotel.getHotelAddress());
					hotelRoomsResponse.setRooms(rooms);
					return hotelRoomsResponse;
				})
				.orElse(null);
	}
}
