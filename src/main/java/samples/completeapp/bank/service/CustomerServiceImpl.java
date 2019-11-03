package samples.completeapp.bank.service;

import samples.completeapp.bank.model.Customer;
import samples.completeapp.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public final class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findByLastName(String lastName) {
        return this.customerRepository.findByLastName(lastName);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> findRichCustomers(float minimumAmount) {
        return this.customerRepository.findRichCustomers(minimumAmount);
    }
}


