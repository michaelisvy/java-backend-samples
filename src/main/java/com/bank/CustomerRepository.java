package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private EntityManager entityManager;

    Customer findByLastName(String lastName) {
        Query query =  entityManager.createQuery("from Customer c join fetch c.accounts where c.lastName=:lastName");
        query.setParameter("lastName", lastName);
        return (Customer) query.getSingleResult();
    }



    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> findRichCustomers(float minimumAmount) {
        Query query = entityManager.createQuery("select c from Customer c join c.accounts a where a.amount > :amount");
        query.setParameter("amount", minimumAmount);
        Object o =   query.getResultList();
        return (List<Customer>) o;
    }
}
