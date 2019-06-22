package nl.kolkos.cryptowatcher.repositories;

import nl.kolkos.cryptowatcher.entities.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

    Optional<Coin> findBySymbol(String symbol);

}
