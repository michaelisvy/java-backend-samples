package samples.security.permissions;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class PermRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_application",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id")
    )
    // Using a Set instead of a List because a single JPQL query cannot fetch multiple lists
    //https://hibernate.atlassian.net/browse/HHH-1718
    private Set<PermApplication> applicationList = new HashSet<>();

    public PermRole(String name) {
        this.name = name;
    }

    private PermRole() {
    }

    public void addApplication(PermApplication application) {
        this.applicationList.add(application);
    }
}
