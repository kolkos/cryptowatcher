package nl.kolkos.cryptowatcher.repositories;

import nl.kolkos.cryptowatcher.entities.CoinValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinValueRepository extends JpaRepository<CoinValue, Long> {

}
