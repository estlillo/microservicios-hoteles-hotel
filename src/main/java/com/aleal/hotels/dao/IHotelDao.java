package com.aleal.hotels.dao;

import org.springframework.data.repository.CrudRepository;

import com.aleal.hotels.model.Hotel;

public interface IHotelDao extends CrudRepository<Hotel, Long> {

}
