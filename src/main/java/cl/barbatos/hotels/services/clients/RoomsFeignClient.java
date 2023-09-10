package cl.barbatos.hotels.services.clients;

import cl.barbatos.hotels.model.dto.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("rooms")
public interface RoomsFeignClient {
    //configure feign client

    //se debe especificar el endpoint del microservicio al que se quiere acceder
    @RequestMapping(method = RequestMethod.GET, value = "roomsByHotelId/{id}", consumes = "application/json")
    List<Room> searchByHotelId(@PathVariable  Long id);


}
