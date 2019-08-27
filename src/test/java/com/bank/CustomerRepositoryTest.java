package com.bank;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void initialiseCustomers() {
		this.customerRepository.save(new Customer("Jack", "Bauer"));
		this.customerRepository.save(new Customer("Chloe", "O'Brian"));
		this.customerRepository.save(new Customer("Kim", "Bauer"));
		this.customerRepository.save(new Customer("David", "Palmer"));
		this.customerRepository.save(new Customer("Michelle", "Dessler"));
	}

	@Test
	public void shouldFindCustomer() {
		List<Customer> customerList = this.customerRepository.findByLastName("Bauer");
		Customer customer = customerList.get(0);
		Assertions.assertThat(customer.getFirstName()).isEqualTo("Jack");
	}

}
