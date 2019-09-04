package com.bank.service;

import com.bank.repository.CustomerRepository;
import com.bank.repository.CustomerRepositoryJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryJpaImpl();
} // Singleton
