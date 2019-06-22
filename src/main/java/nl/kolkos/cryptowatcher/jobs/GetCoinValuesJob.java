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

    private CoinService coinService;

    @Autowired
    public GetCoinValuesJob(CoinService coinService) {
        this.coinService = coinService;
    }

    @Scheduled(fixedRate = 10000)
    public void getCoinValues() {
        LOGGER.info("Registering coins");

        Coin btc = new Coin("Bitcoin", "btc");
        coinService.save(btc);

    }

}
