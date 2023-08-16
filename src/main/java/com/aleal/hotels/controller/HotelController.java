package com.aleal.hotels.controller;

import java.util.List;

import com.aleal.hotels.config.HotelsServiceConfig;
import com.aleal.hotels.model.PropertiesHotels;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;

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

	@GetMapping("hotels/properties")
	public String getProperties() throws JsonProcessingException{

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels propertiesHotels = new PropertiesHotels(config.getMsg(), config.getBuildVersion(), config.getMailDetails());

		return ow.writeValueAsString(propertiesHotels);
	}

}
