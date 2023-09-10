package cl.barbatos.hotels.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRooms {

    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private List<Room> rooms;

}
