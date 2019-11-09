package samples.jpa.threeway;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TwUserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void shouldSaveAUserWithRolesAndCompany() {
        TwUser user = new TwUser("John Smith");

        TwRole role = new TwRole("HR");
        TwCompany company = new TwCompany("Spotify");
        user.addRoleAndCompany(role, company);
        this.entityManager.persist(role);
        this.entityManager.persist(company);
        this.entityManager.persist(user);
        assertThat(user.getId()).isGreaterThan(0);

    }
}
