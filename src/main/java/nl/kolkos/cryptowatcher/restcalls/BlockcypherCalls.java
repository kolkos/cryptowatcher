package nl.kolkos.cryptowatcher.restcalls;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockcypherCalls {

    @Autowired
    private RestClient restClient;

    public void getCurrentWalletValue(Coin coin, Wallet wallet) {
        String url = String.format("https://api.blockcypher.com/v1/%s/main/addrs/%s/balance", coin.getSymbol(), wallet.getAddress());

    }


}
