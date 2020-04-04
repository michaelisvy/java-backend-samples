package samples.completeapp.bank.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import samples.completeapp.bank.model.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c join c.accounts a where a.amount > :minimumAmount")
    List<Customer> findRichCustomersOneAccount(float minimumAmount);

    @Query("select c from Customer c join c.accounts a GROUP BY (c.id) HAVING SUM(a.amount)>= :minimumAmount")
    List<Customer> findRichCustomersMultipleAccounts(double minimumAmount);

    @Query("from Customer c join fetch c.accounts where c.lastName =:lastName")
    public Customer findByLastName(String lastName);
}
