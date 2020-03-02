package samples.jpa.manytomany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MtmCustomerRepositoryTest {

    public static final String LAST_NAME = "Smith";
    public static final String FIRST_NAME = "John";

    @Autowired
    private MtmCustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void saveCustomer() {
        MtmCustomer customer = new MtmCustomer(FIRST_NAME, LAST_NAME);
        customer.addAccount(new MtmAccount((10)));
        this.customerRepository.save(customer);
        assertThat(customer.getId()).isGreaterThan(0);
        this.entityManager.flush();
        this.entityManager.detach(customer);
    }


    @Test
    @Transactional
    public void shouldFindCustomerWithAccount() {
        MtmCustomer customer = this.customerRepository.findByLastName(LAST_NAME);
        assertThat(customer.getFirstName()).isEqualTo(FIRST_NAME);

    }
}
