package samples.jpa.onetomany;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OtmAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;

    public OtmAccount() {
    }

    public OtmAccount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
