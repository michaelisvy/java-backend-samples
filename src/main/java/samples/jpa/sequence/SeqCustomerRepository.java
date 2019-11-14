package samples.jpa.sequence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeqCustomerRepository extends CrudRepository<SeqCustomer, Long> {
    @Query("from SeqCustomer c join fetch c.addresses a where c.lastName =:lastName")
    public SeqCustomer findByLastName(String lastName);
}
