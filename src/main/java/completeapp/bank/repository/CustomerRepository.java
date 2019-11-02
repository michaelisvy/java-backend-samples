package completeapp.bank.repository;

import completeapp.bank.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);

    List<Customer> findRichCustomers(float minimumAmount);

    Customer findByLastName(String lastName);
}
