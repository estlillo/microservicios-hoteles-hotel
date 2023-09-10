package cl.barbatos.hotels.controller;

import java.util.List;

import cl.barbatos.hotels.model.Hotel;
import cl.barbatos.hotels.config.HotelsServiceConfig;
import cl.barbatos.hotels.model.PropertiesHotels;
import cl.barbatos.hotels.model.dto.HotelRooms;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.barbatos.hotels.services.IHotelService;

@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;

	@Autowired
	private HotelsServiceConfig config;
	
	
	@GetMapping("hotels")
	public List<Hotel> search(){
		return (List<Hotel>) this.service.search();	
	}

	@GetMapping("hotels/{id}")
	public HotelRooms searchHotelRoomsById(@PathVariable Long id) {
		return this.service.searchHotelRoomsById(id);
	}

	@GetMapping("hotels/properties")
	public String getProperties() throws JsonProcessingException{

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels propertiesHotels = new PropertiesHotels(config.getMsg(), config.getBuildVersion(), config.getMailDetails());

		return ow.writeValueAsString(propertiesHotels);
	}

}
