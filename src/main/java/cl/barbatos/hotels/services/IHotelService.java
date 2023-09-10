package cl.barbatos.hotels.services;

import java.util.List;

import cl.barbatos.hotels.model.Hotel;
import cl.barbatos.hotels.model.dto.HotelRooms;

public interface IHotelService {
	
	List<Hotel> search();

	HotelRooms searchHotelRoomsById(Long id);


	HotelRooms searchHotelRoomsByIdFeing(Long id);
}
