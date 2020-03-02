package samples.jpa.manytomany;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MtmCustomerRepository extends CrudRepository<MtmCustomer, Long> {
    @Query("from MtmCustomer c join fetch c.accounts where c.lastName =:lastName")
    public MtmCustomer findByLastName(String lastName);
}
