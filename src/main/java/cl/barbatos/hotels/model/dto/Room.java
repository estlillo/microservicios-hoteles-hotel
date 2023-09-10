package cl.barbatos.hotels.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
    private Long roomId;
    private Long hotelId;
    private String roomName;
    private String roomAvailable;
}
