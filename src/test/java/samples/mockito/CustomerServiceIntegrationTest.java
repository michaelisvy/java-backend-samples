package samples.mockito;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class CustomerServiceIntegrationTest {

    @Autowired
    private MckCustomerService customerService;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldRetrieveCustomer() {
        MckCustomer mckCustomer = new MckCustomer("Billy", "Eliot");
        this.entityManager.persist(mckCustomer);

        MckCustomer customer = this.customerService.findByLastName("Eliot");
        assertThat(customer.getId()).isGreaterThan(0L);
        assertThat(customer.getFirstName()).isEqualTo("Billy");
    }

}
