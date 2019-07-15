package nl.kolkos.cryptowatcher.controllers;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coins")
public class CoinController {

    private CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }




    @GetMapping("/register")
    public String registerCoin(@RequestParam String coinName, @RequestParam String symbol){
        Coin coin = new Coin(coinName, symbol);
        coinService.save(coin);

        return "Success!";
    }

}
