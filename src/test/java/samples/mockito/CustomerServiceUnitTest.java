package samples.mockito;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class CustomerServiceUnitTest {

    @Autowired
    private MckCustomerService customerService;

    @MockBean
    private MckCustomerRepository customerRepository;

    @Test
    public void shouldRetrieveCustomer() {
        when(customerRepository.findByLastName("Eliot")).thenReturn(new MckCustomer("Billy", "Eliot"));

        MckCustomer customer = this.customerService.findByLastName("Eliot");
        assertThat(customer.getFirstName()).isEqualTo("Billy");
    }

}
