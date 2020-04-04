package samples.completeapp.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import samples.completeapp.bank.model.Customer;
import samples.completeapp.bank.repository.CustomerRepository;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByLastName(String lastName) {
        return this.customerRepository.findByLastName(lastName);
    }

    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    public void update(Customer customer) {
        this.customerRepository.save(customer);
    }

    public List<Customer> findRichCustomersOneAccount(float minimumAmount) {
        return this.customerRepository.findRichCustomersOneAccount(minimumAmount);
    }

    public List<Customer> findRichCustomersMultipleAccount(double minimumAmount) {
        return this.customerRepository.findRichCustomersMultipleAccounts(minimumAmount);
    }

    public void deleteById(long id) {
        this.customerRepository.deleteById(id);
    }
}


