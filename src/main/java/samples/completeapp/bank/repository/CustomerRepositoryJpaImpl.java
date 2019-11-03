package samples.completeapp.bank.repository;

import samples.completeapp.bank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerRepositoryJpaImpl implements CustomerRepository {

    public static final String SELECT_RICH_CUSTOMERS_WITHOUT_ACCOUNTS = "select c from Customer c join c.accounts a where a.amount > :amount";
    public static final String SELECT_CUSTOMERS_WITH_ACCOUNTS_BY_NAME = "from Customer c join fetch c.accounts where c.lastName=:lastName";
    @Autowired
    private EntityManager entityManager;

    @Override
    public Customer findByLastName(String lastName) {
        Query query = entityManager.createQuery(SELECT_CUSTOMERS_WITH_ACCOUNTS_BY_NAME);
        query.setParameter("lastName", lastName);
        return (Customer) query.getSingleResult();
    }


    @Override
    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public List<Customer> findRichCustomers(float minimumAmount) {
        Query query = entityManager.createQuery(SELECT_RICH_CUSTOMERS_WITHOUT_ACCOUNTS);
        query.setParameter("amount", minimumAmount);
        Object o = query.getResultList();
        return (List<Customer>) o;
    }
}
