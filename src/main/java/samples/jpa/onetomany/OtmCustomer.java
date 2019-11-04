package samples.jpa.onetomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Data
public class OtmCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<OtmAccount> accounts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Set<OtmAddress> addresses = new HashSet<>();

    @Version
    private int version;

    protected OtmCustomer() {
    }

    public OtmCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(OtmAccount account) {
        accounts.add(account);
    }

    public void addAddress(OtmAddress address) {
        addresses.add(address);
    }
}
