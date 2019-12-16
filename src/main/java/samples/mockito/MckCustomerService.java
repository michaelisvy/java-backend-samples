package samples.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class MckCustomerService {

    @Autowired
    private MckCustomerRepository customerRepository;

    @Query("from MckCustomer c where c.lastName =:lastName")
    public MckCustomer findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
