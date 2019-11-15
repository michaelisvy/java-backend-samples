package samples.security.permissions;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class PermUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<PermRole> roleList = new ArrayList<>();

    public PermUser(String name) {
        this.name = name;
    }

    private PermUser() {
    }

    public void addRole(PermRole role) {
        this.roleList.add(role);
    }
}
