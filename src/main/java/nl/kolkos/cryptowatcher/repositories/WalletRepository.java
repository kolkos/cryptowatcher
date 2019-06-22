package nl.kolkos.cryptowatcher.repositories;

import nl.kolkos.cryptowatcher.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
