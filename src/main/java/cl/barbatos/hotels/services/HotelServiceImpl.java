package cl.barbatos.hotels.services;

import java.util.*;

import cl.barbatos.hotels.model.dto.HotelRooms;
import cl.barbatos.hotels.model.dto.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.barbatos.hotels.dao.IHotelDao;
import cl.barbatos.hotels.model.Hotel;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;

	@Autowired
	private RestTemplate clientRest;

	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}


	@Override
	public HotelRooms searchHotelRoomsById(Long id) {
		return hotelDao.findById(id)
				.map(hotel -> {
					Map<String, Long> pathVariables = Map.of("id", id);
					Room[] rooms = clientRest.getForObject("http://localhost:8088/rooms/hotel/{id}", Room[].class, pathVariables);
					HotelRooms hotelRoomsResponse = new HotelRooms();
					hotelRoomsResponse.setHotelId(hotel.getHotelId());
					hotelRoomsResponse.setHotelName(hotel.getHotelName());
					hotelRoomsResponse.setHotelAddress(hotel.getHotelAddress());
					hotelRoomsResponse.setRooms(Arrays.asList(rooms));
					return hotelRoomsResponse;
				})
				.orElse(null);
	}
}
