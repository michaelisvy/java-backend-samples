package samples.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MckCustomerService {

    @Autowired
    private MckCustomerRepository customerRepository;

    public MckCustomer findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public MckCustomer findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }
}
