package completeapp.bank.service;

import completeapp.bank.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findByLastName(String lastName);

    void save(Customer customer);

    List<Customer> findRichCustomers(float minimumAmount);
}
