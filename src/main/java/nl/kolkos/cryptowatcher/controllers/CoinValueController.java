package nl.kolkos.cryptowatcher.controllers;

import nl.kolkos.cryptowatcher.entities.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coinValues")
public class CoinValueController {




    private final static Logger LOGGER = LoggerFactory.getLogger(CoinValueController.class);

    @GetMapping("/register")
    public String registerCoinValue(@RequestParam String coinName, @RequestParam String symbol) {
        Coin coin = new Coin(coinName, symbol);

        String response = coin.toString();
        LOGGER.info(response);

        return response;
    }


}
