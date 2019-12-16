package samples.mockito;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MckCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    protected MckCustomer() {
    }

    public MckCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
