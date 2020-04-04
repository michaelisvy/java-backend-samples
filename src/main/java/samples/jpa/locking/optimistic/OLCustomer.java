package samples.jpa.locking.optimistic;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OLCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public OLCustomer(String name) {
        this.name = name;
    }

    private OLCustomer() {
    }

    @Version
    private int version;

}
