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

    List<Customer> findByLastName(String lastName) {
        Query query =  entityManager.createQuery("from Customer where lastName=:lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }


}
