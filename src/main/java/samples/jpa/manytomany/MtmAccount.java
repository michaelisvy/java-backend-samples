package samples.jpa.manytomany;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MtmAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;

    public MtmAccount() {
    }

    public MtmAccount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
