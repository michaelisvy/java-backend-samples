package samples.completeapp.bank.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import samples.annotation.OPServiceTest;
import samples.completeapp.bank.model.Account;
import samples.completeapp.bank.model.Customer;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

/*
Uses Default database (H2)
 */
@OPServiceTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    private void saveRichCustomer() {
        Customer customer = new Customer("Bill", "Gates", null);
        customer.addAccount(new Account(1000000));
        customer.addAccount(new Account(2000000));
        this.customerService.save(customer);
    }

    @Test
    public void shouldFindCustomer() {
        Customer customer = this.customerService.findByLastName("Bauer");
        assertThat(customer.getFirstName()).isEqualTo("Jack");
    }

    @Test
    @Transactional
    // @Transactional is needed because Hibernate session needs to remain open when we do customer.getAccount()
    public void shouldFindRichCustomersOneAccount() {
        float minimumAmount = 500;
        List<Customer> customers = this.customerService.findRichCustomersOneAccount(minimumAmount);
        Account firstAccount = customers.get(0).getAccounts().get(0);
        assertThat(firstAccount.getAmount()).isGreaterThanOrEqualTo(minimumAmount);
    }

    @Test
    @Transactional
    public void shouldFindRichCustomersMultipleAccount() {
        this.saveRichCustomer();
        float minimumAmount = 2000000;
        List<Customer> customers = this.customerService.findRichCustomersMultipleAccount(minimumAmount);
        assertThat(customers.size()).isEqualTo(1);
        Account firstAccount = customers.get(0).getAccounts().get(0);
        assertThat(firstAccount.getAmount()).isGreaterThanOrEqualTo(1000000);
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
