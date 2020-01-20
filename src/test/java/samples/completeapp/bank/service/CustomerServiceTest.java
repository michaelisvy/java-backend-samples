package samples.completeapp.bank.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import samples.SamplesApplication;
import samples.completeapp.bank.model.Account;
import samples.completeapp.bank.model.Customer;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

/*
Uses Default database (H2)
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SamplesApplication.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void shouldFindCustomer() {
        Customer customer = this.customerService.findByLastName("Bauer");
        assertThat(customer.getFirstName()).isEqualTo("Jack");
    }

    @Test
    @Transactional
    // @Transactional is needed because Hibernate session needs to remain open when we do customer.getAccount()
    public void shouldFindRichCustomers() {
        float minimumAmount = 500;
        List<Customer> customers = this.customerService.findRichCustomers(minimumAmount);
        Account firstAccount = customers.get(0).getAccounts().get(0);
        assertThat(firstAccount.getAmount()).isGreaterThanOrEqualTo(minimumAmount);
    }

    @Test
    public void shouldFindCustomerWithAccounts() {
        Customer customer = this.customerService.findByLastName("Bauer");
        Account account = customer.getAccounts().iterator().next();
        assertThat(account.getAmount()).isEqualTo(50);
    }

    @Test
    public void shouldSaveCustomer() {
        UUID customerUUid = UUID.randomUUID();
        Customer customer = new Customer("Eric", "Dupont", customerUUid);
        customer.addAccount(new Account(1000000));
        this.customerService.save(customer);
        Customer retrievedCustomer = this.customerService.findByLastName("Dupont");
        assertThat(retrievedCustomer.getFirstName()).isEqualTo("Eric");
        assertThat(retrievedCustomer.getUuid()).isEqualTo(customerUUid);
    }
}
