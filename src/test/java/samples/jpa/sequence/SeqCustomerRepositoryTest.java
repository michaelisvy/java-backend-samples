package samples.jpa.sequence;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class SeqCustomerRepositoryTest {

    public static final String LAST_NAME = "Smith";
    public static final String FIRST_NAME = "John";
    @Autowired
    private SeqCustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void saveCustomer() {
        SeqCustomer customer = new SeqCustomer(FIRST_NAME, LAST_NAME);
        customer.addAddress(new SeqAddress("3, Serangoon avenue 12", "558136"));
        this.customerRepository.save(customer);
        assertThat(customer.getId()).isGreaterThan(0);
        this.entityManager.flush();
        this.entityManager.detach(customer);

    }


    @Test
    @Transactional
    public void shouldFindCustomerWithAccount() {
        SeqCustomer customer = this.customerRepository.findByLastName(LAST_NAME);
        Hibernate.initialize(customer.getAddresses());
        assertThat(customer.getFirstName()).isEqualTo(FIRST_NAME);

    }

}
