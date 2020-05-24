package samples.completeapp.bank.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;
    private String name;

    public Account() {
    }

    public Account(float amount) {
        this.amount = amount;
    }

}
