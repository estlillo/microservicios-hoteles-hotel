package cl.barbatos.hotels.dao;

import cl.barbatos.hotels.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface IHotelDao extends CrudRepository<Hotel, Long> {

}
