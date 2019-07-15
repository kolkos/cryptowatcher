package nl.kolkos.cryptowatcher.services;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.repositories.CoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoinService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CoinService.class);

    @Autowired
    private CoinRepository coinRepository;

    public Coin save(Coin coin) {
        Optional<Coin> coinInDatabase = coinRepository.findBySymbol(coin.getSymbol());
        return coinInDatabase.orElseGet(() -> coinRepository.save(coin));
    }


}
