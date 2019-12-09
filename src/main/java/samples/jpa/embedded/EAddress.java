package samples.jpa.embedded;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data @Embeddable
public class EAddress {
    @Column(name = "address_street")
    private String street;
    @Column(name = "address_city")
    private String city;

    public EAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public EAddress() {
    }
}
