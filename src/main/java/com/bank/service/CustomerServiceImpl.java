package com.bank.service;

import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findByLastName(String lastName) {
        return this.customerRepository.findByLastName(lastName);
    }

    @Override @Transactional
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }
}


