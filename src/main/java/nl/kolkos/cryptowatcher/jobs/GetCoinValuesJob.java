package nl.kolkos.cryptowatcher.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GetCoinValuesJob {
    private final static Logger LOGGER = LoggerFactory.getLogger(GetCoinValuesJob.class);

    @Scheduled(cron = "0 * * * * *")
    public void getCoinValues() {
        LOGGER.info("Getting coin values");
    }

}
