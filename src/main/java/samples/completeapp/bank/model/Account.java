package samples.completeapp.bank.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;

    public Account() {
    }

    public Account(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
