package samples.mockito;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MckCustomerRepository extends CrudRepository<MckCustomer, Long> {
    @Query("from MckCustomer c where c.lastName =:lastName")
    public MckCustomer findByLastName(String lastName);
}
