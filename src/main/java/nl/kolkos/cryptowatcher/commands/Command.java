package nl.kolkos.cryptowatcher.commands;

import nl.kolkos.cryptowatcher.entities.Coin;
import nl.kolkos.cryptowatcher.entities.Wallet;

public interface Command {
    void run();
    void init(Wallet wallet, Coin coin);
    String getUrl();
    String getResponse();
    Wallet getWallet();
    Coin getCoin();


}
