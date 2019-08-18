package nl.kolkos.cryptowatcher.services;

import nl.kolkos.cryptowatcher.entities.Wallet;
import nl.kolkos.cryptowatcher.repositories.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final static Logger LOGGER = LoggerFactory.getLogger(WalletService.class);

    private WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

}
