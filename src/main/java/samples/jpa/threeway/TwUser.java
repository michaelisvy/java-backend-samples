package samples.jpa.threeway;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class TwUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JoinTable(name = "user_role_company",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    @MapKeyJoinColumn(name = "role_id")
    @ElementCollection
    private Map<TwRole, TwCompany> rolesAndCompanies = new HashMap<>();
    public TwUser(String name) {
        this.name = name;
    }

    private TwUser() {
    }

    public void addRoleAndCompany(TwRole role, TwCompany company) {
        rolesAndCompanies.put(role, company);
    }
}
