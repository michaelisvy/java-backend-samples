package samples.jpa.onetomany;



import javax.persistence.*;

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
