package nl.kolkos.cryptowatcher.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue
    private long id;

    private String address;
    private String description;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "coin_id")
    private Coin coin;


}
