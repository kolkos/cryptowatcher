package nl.kolkos.cryptowatcher.commands;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.entities.Wallet;

public class GetCurrentWalletValueCommand implements Command {
    private Wallet wallet;
    private String url;
    private String response;

    @Override
    public void run() {

    }

    @Override
    public void init(Wallet wallet, Coin coin) {
        this.wallet = wallet;
        this.url = String.format("https://api.blockcypher.com/v1/%s/main/addrs/%s/balance", wallet.getCoin().getSymbol(), wallet.getAddress());
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public Wallet getWallet() {
        return this.wallet;
    }

    @Override
    public Coin getCoin() {
        return null;
    }
}
