package samples.completeapp.bank.repository;

import samples.completeapp.bank.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);

    List<Customer> findRichCustomers(float minimumAmount);

    Customer findByLastName(String lastName);
}
