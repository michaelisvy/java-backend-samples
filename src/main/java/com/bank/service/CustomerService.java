package com.bank.service;

import com.bank.model.Customer;

public interface CustomerService {
    Customer findByLastName(String lastName);

    void save(Customer customer);
}
