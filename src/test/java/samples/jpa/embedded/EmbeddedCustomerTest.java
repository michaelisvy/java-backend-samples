package samples.jpa.embedded;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
public class EmbeddedCustomerTest {
    @Autowired
    private EntityManager entityManager;

    @Test @Transactional
    public void shouldPersistedEmbeddedAddress() {
        ECustomer customer = new ECustomer("John", "Smith");
        customer.setAddress(new EAddress("Serangoon Avenue 2", "Singapore"));
        this.entityManager.persist(customer);
        Assertions.assertThat(customer.getId()).isGreaterThan(0);


    }
}
