package samples.jpa.threeway;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Data
public class TwRole {

    public TwRole(String name) {
        this.name = name;
    }

    private TwRole() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
