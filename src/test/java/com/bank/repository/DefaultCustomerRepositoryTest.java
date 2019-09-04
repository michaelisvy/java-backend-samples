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

	@Before
	public void initialize() {
		List<Account> accounts1 = new ArrayList<>();
		accounts1.add(new Account(50));
		accounts1.add(new Account(100));
		Customer customer1 = new Customer("Jack", "Bauer");
		customer1.setAccounts(accounts1);

		List<Account> accounts2 = new ArrayList<>();
		accounts2.add(new Account(500));
		accounts2.add(new Account(1000));
		Customer customer2 = new Customer("Chloe", "O'Brian");
		customer2.setAccounts(accounts2);

		this.customerRepository.save(customer1);
		this.customerRepository.save(customer2);
	}

	@Test @Transactional
	public void shouldFindCustomer() {
		Customer customer = this.customerRepository.findByLastName("Bauer");
		Assertions.assertThat(customer.getFirstName()).isEqualTo("Jack");
	}

	@Test @Transactional
	public void shouldFindRichCustomers() {
		float minimumAmount = 500;
		List<Customer> customers = this.customerRepository.findRichCustomers(minimumAmount);
		Account firstAccount = customers.get(0).getAccounts().get(0);
		Assertions.assertThat(firstAccount.getAmount()).isGreaterThanOrEqualTo(minimumAmount);
	}

	@Test @Transactional
	public void shouldFindCustomerWithAccounts() {
		Customer customer = this.customerRepository.findByLastName("Bauer");
		Account account = customer.getAccounts().iterator().next();
		Assertions.assertThat(account.getAmount()).isEqualTo(50);
	}

	@Test @Transactional
	public void testDatabaseProvider() throws Exception {
		String databaseUrl = this.dataSource.getConnection().getMetaData().getURL();
		assertThat(databaseUrl).contains("h2");
	}


}
