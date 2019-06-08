package nl.kolkos.cryptowatcher.configurations;

import nl.kolkos.cryptowatcher.receivers.Receiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Receiver receiver(){
        return new Receiver();
    }

}
