package com.bank;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRepositoryTest  {

	@Autowired
	private CustomerRepository customerRepository;

	private Customer customer1;
	private Customer customer2;

	@Before
	public void initialize() {
		Account[] accounts1 = new Account[]{new Account(50),new Account(100)};
		customer1 = new Customer("Jack", "Bauer");
		customer1.setAccountList(Arrays.asList(accounts1));

		Account[] accounts2 = new Account[]{new Account(500),new Account(1000)};
		customer2 = new Customer("Chloe", "O'Brian");
		customer2.setAccountList(Arrays.asList(accounts2));

		this.customerRepository.save(customer1);
		this.customerRepository.save(customer2);
	}

	@Test @Transactional
	public void shouldFindCustomer() {
		Customer customer = this.customerRepository.findByLastName("Bauer");
		Assertions.assertThat(customer.getFirstName()).isEqualTo("Jack");
	}

	@Test @Transactional
	public void shouldFindCustomerWithAccounts() {
		Customer customer = this.customerRepository.findByLastName("Bauer");
		Account account = customer.getAccountList().get(0);
		Assertions.assertThat(account.getAmount()).isEqualTo(50);
	}


}
