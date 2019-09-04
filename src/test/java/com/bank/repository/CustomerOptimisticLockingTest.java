package com.bank.repository;

import com.bank.Application;
import com.bank.model.Customer;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerOptimisticLockingTest {

    @Autowired
    private EntityManager entityManager;

    @Test @Transactional
    public void shouldHaveOptimisticLockingConflict() {
        Customer customer = new Customer("joe", "black");
        this.entityManager.persist(customer);

        Customer customer1 = this.entityManager.find(Customer.class, 1L);
        Customer customer2 = this.entityManager.find(Customer.class, 1L);

        assertThat(customer1.getFirstName()).isEqualTo("joe");
        assertThat(customer1.getVersion()).isEqualTo(0);
        assertThat(customer2.getVersion()).isEqualTo(0);

        customer1.setFirstName("joe1");
        customer2.setFirstName("joe2");

        this.entityManager.persist(customer1);
        this.entityManager.persist(customer2);

        /*Assert.assertEquals(Integer.valueOf(0), account1.getVersion());
        Assert.assertEquals(Integer.valueOf(0), account2.getVersion());
​
        account1.setBalance(account1.getBalance() - 2000F);
        account2.setBalance(account2.getBalance() - 2500F);
​
        accountRepository.save(account1);
        account1 = accountRepository.findById(1L).get();
        Assert.assertEquals(Integer.valueOf(1), account1.getVersion());
        accountRepository.save(account2);*/

    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)  @Rollback(false)
    public void persistCustomer(Customer customer) {
        this.entityManager.persist(customer);
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)  @Rollback(false)
    public void updateCustomer(String newFirstName) {
        Query query = this.entityManager.createQuery("from Customer where firstName = :firstName");
        query.setParameter("firstName", "joe");
        Customer customer = (Customer) query.getSingleResult();
        customer.setFirstName(newFirstName);
    }


}
