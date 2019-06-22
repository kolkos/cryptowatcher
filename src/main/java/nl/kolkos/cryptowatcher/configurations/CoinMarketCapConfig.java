package nl.kolkos.cryptowatcher.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "coinmarketcap")
@Data
public class CoinMarketCapConfig {
}
