package samples.jpa.sequence;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class SeqCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(
            name = "customer_seq",
            sequenceName = "course_sequence",
            allocationSize = 20
    )
    private Long id;
    private String firstName;
    private String lastName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Set<SeqAddress> addresses = new HashSet<>();

    @Version
    private int version;

    protected SeqCustomer() {
    }

    public SeqCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAddress(SeqAddress address) {
        addresses.add(address);
    }
}
