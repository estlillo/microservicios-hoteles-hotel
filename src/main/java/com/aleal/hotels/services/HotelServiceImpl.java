package com.aleal.hotels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleal.hotels.dao.IHotelDao;
import com.aleal.hotels.model.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;

	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}
}
