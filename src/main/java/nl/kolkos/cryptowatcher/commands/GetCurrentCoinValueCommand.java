package nl.kolkos.cryptowatcher.commands;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.entities.Wallet;

public class GetCurrentCoinValueCommand implements Command {
    private Wallet wallet;
    private Coin coin;
    private String url;
    private String response;


    @Override
    public void run() {

    }

    @Override
    public void init(Wallet wallet, Coin coin) {
        this.wallet = wallet;
        this.coin = coin;

    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getResponse() {
        return this.response;
    }

    @Override
    public Wallet getWallet() {
        return this.wallet;
    }

    @Override
    public Coin getCoin() {
        return this.coin;
    }
}
