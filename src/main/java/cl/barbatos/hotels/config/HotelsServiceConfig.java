package cl.barbatos.hotels.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration // Enable Spring Cloud Config Server test 1
@ConfigurationProperties(prefix = "hotels")
@Getter
@Setter
public class HotelsServiceConfig {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}
