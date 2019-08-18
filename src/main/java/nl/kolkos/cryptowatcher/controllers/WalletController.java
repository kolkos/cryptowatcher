package nl.kolkos.cryptowatcher.controllers;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.entities.Wallet;
import nl.kolkos.cryptowatcher.services.CoinService;
import nl.kolkos.cryptowatcher.services.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WalletController.class);

    private WalletService walletService;
    private CoinService coinService;

    @Autowired
    public WalletController(WalletService walletService, CoinService coinService) {
        this.walletService = walletService;
        this.coinService = coinService;
    }




    @GetMapping("/register")
    public String registerCoin(@RequestParam String coinSymbol, @RequestParam String address) {

        // first find the coin
        Coin coin = coinService.findCoinBySymbol(coinSymbol).orElseThrow(() -> new RuntimeException("Could not find coin " + coinSymbol));

        Wallet wallet = new Wallet(address, String.format("%s wallet", coin.getName()), coin);

        walletService.save(wallet);
        LOGGER.info(wallet.toString());

        return wallet.toString();
    }
}
