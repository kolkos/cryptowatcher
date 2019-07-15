package nl.kolkos.cryptowatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptowatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptowatcherApplication.class, args);
    }

}
