package samples.completeapp.bank.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Account> accounts = new ArrayList<>();

    @Version @JsonIgnore
    private int version;

    protected Customer() {
    }

    public Customer(String firstName, String lastName, UUID uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
