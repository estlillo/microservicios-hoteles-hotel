package cl.barbatos.hotels.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clientRest") //Register a bean of type RestTemplate
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
