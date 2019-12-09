package samples.jpa.embedded;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ECustomer {

    public ECustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ECustomer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Embedded
    private EAddress address;
}
