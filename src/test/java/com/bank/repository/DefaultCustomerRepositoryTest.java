package com.bank.repository;

import com.bank.Application;
import com.bank.model.Account;
import com.bank.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DefaultCustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DataSource dataSource;

	@Test
	public void shouldFindCustomer() {
		Customer customer = this.customerRepository.findByLastName("Bauer");
		Assertions.assertThat(customer.getFirstName()).isEqualTo("Jack");
	}

	@Test @Transactional
	// @Transactional is needed because Hibernate session needs to remain open when we do customer.getAccount()
	public void shouldFindRichCustomers() {
		float minimumAmount = 500;
		List<Customer> customers = this.customerRepository.findRichCustomers(minimumAmount);
		Account firstAccount = customers.get(0).getAccounts().get(0);
		Assertions.assertThat(firstAccount.getAmount()).isGreaterThanOrEqualTo(minimumAmount);
	}

	@Test
	public void shouldFindCustomerWithAccounts() {
		Customer customer = this.customerRepository.findByLastName("Bauer");
		Account account = customer.getAccounts().iterator().next();
		Assertions.assertThat(account.getAmount()).isEqualTo(50);
	}

	@Test
	public void testDatabaseProvider() throws Exception {
		String databaseUrl = this.dataSource.getConnection().getMetaData().getURL();
		assertThat(databaseUrl).contains("h2");
	}

	@Test
	public void shouldSaveCustomer() {
		Customer customer = new Customer("Eric", "Dupont");
		customer.addAccount(new Account(1000000));
		this.customerRepository.save(customer);
		Customer retrievedCustomer = this.customerRepository.findByLastName("Dupont");
		assertThat(retrievedCustomer.getFirstName()).isEqualTo("Eric");
	}


}
