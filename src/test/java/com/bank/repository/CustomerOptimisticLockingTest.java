package com.bank.repository;

import com.bank.Application;
import com.bank.model.Customer;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerOptimisticLockingTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setup() {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer1 = new Customer("joe", "black");
        entityManager.persist(customer1);
        transaction.commit();
    }

    @Test @Ignore
    public void shouldHaveOptimisticLockingConflict() {
        EntityManager entityManager1 = this.entityManagerFactory.createEntityManager();
        Customer customer1 = entityManager1.find(Customer.class, 1L);
        EntityTransaction transaction1 = entityManager1.getTransaction();
        transaction1.begin();
        customer1.setFirstName("joe1");
        transaction1.commit();

        EntityManager entityManager2 = this.entityManagerFactory.createEntityManager();
        Customer customer2 = entityManager2.find(Customer.class, 1L);
        EntityTransaction transaction2 = entityManager2.getTransaction();


        customer2.setFirstName("joe2");
        transaction2.commit();

    }

}
