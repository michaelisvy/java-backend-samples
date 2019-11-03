package samples.jpa.onetomany;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data
public class OtmAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipCode;

    public OtmAddress(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

    protected OtmAddress() {
    }
}
