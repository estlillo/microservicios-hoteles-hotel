package cl.barbatos.hotels.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertiesHotels {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}
