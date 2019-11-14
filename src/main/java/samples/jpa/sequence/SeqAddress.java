package samples.jpa.sequence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SeqAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipCode;

    public SeqAddress(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    protected SeqAddress() {
    }
}
