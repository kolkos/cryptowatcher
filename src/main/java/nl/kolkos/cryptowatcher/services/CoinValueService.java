package nl.kolkos.cryptowatcher.services;

import nl.kolkos.cryptowatcher.repositories.CoinValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinValueService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CoinValueService.class);

    private CoinValueRepository coinValueRepository;

    @Autowired
    public CoinValueService(CoinValueRepository coinValueRepository) {
        this.coinValueRepository = coinValueRepository;
    }
}
