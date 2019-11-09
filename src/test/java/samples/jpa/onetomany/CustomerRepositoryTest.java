package samples.jpa.onetomany;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import samples.SamplesApplication;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SamplesApplication.class)
public class CustomerRepositoryTest {

    public static final String LAST_NAME = "Smith";
    public static final String FIRST_NAME = "John";
    @Autowired
    private OtmCustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void saveCustomer() {
        OtmCustomer customer = new OtmCustomer(FIRST_NAME, LAST_NAME);
        customer.addAccount(new OtmAccount((10)));
        customer.addAddress(new OtmAddress("3, Serangoon avenue 12", "558136"));
        this.customerRepository.save(customer);
        assertThat(customer.getId()).isGreaterThan(0);
        this.entityManager.flush();
        this.entityManager.detach(customer);

    }


    @Test
    @Transactional
    public void shouldFindCustomerWithAccount() {
        OtmCustomer customer = this.customerRepository.findByLastName(LAST_NAME);
        Hibernate.initialize(customer.getAddresses());
        assertThat(customer.getFirstName()).isEqualTo(FIRST_NAME);

    }

}
