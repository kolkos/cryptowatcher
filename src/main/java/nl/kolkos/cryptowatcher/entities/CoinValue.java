package nl.kolkos.cryptowatcher.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CoinValue {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "coin_id")
    private Coin coin;

    private Date requestDate;
    private double value;

    @PrePersist
    void createdAt() {
        this.requestDate = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.requestDate = new Date();
    }
}
