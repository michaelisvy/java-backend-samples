package samples.jpa.onetomany;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtmCustomerRepository extends CrudRepository <OtmCustomer, Long> {
    @Query("from OtmCustomer c join fetch c.accounts join fetch c.addresses a where c.lastName =:lastName")
    public OtmCustomer findByLastName(String lastName);
}
