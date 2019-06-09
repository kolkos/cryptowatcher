package nl.kolkos.cryptowatcher.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Coin {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String symbol;



}
