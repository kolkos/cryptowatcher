package nl.kolkos.cryptowatcher.jobs;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.services.CoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GetCoinValuesJob {
    private final static Logger LOGGER = LoggerFactory.getLogger(GetCoinValuesJob.class);

    @Autowired
    private CoinService coinService;

    @Scheduled(fixedDelay = 10000 * 60 * 60)
    public void getCoinValues() {
        LOGGER.info("Registering coins");

        Coin btc = new Coin("Bitcoin", "btc");
        coinService.save(btc);



    }

    private final String getUrl() {
        return "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?convert=EUR";
    }

}
