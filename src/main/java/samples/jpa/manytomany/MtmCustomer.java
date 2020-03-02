package samples.jpa.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class MtmCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "mtm_customer_mtm_account",
            joinColumns = @JoinColumn(name = "mtm_customer_id"),
            inverseJoinColumns = @JoinColumn(name = "mtm_account_id"))
    private List<MtmAccount> accounts = new ArrayList<>();

    protected MtmCustomer() {
    }

    public MtmCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(MtmAccount account) {
        accounts.add(account);
    }

}
