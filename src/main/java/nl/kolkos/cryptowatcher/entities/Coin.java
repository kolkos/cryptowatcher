package nl.kolkos.cryptowatcher.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Coin {

    @Id
    private String name;
    private String symbol;

    public Coin(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

}
