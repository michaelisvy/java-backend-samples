package samples.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
public class CustomerServiceUnitTest {

    @Autowired
    private MckCustomerService customerService;

    @MockBean
    private MckCustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void init() {
        MckCustomer customer = new MckCustomer("real first name", "real last name");
        this.entityManager.persist(customer);
        this.entityManager.detach(customer);
    }

    @Test
    public void shouldRetrieveFromMock() {
        when(customerRepository.findByLastName("Eliot")).thenReturn(new MckCustomer("Billy", "Eliot"));
        MckCustomer customer = this.customerService.findByLastName("Eliot");
        verify(customerRepository, times(1)).findByLastName("Eliot");
        assertThat(customer.getFirstName()).isEqualTo("Billy");
    }

    @Test
    public void nonMockedMethodShouldReturnNull() {
        MckCustomer customer = this.customerService.findByLastName("real last name");
        verify(customerRepository, times(1)).findByLastName("real last name");
        assertThat(customer).isNull();
    }

}
