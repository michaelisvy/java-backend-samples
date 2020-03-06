package samples.jpa.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest @Transactional
public class BasicCustomerUpdateTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldCreateCustomers() {
        BasicCustomer customer1 = new BasicCustomer("John", "Smith");
        BasicCustomer customer2 = new BasicCustomer("Paul", "Bert");
        this.entityManager.persist(customer1);
        this.entityManager.persist(customer2);
        //this.entityManager.clear();

        customer1.setFirstName("aa");
        customer2.setFirstName("bb");
        this.entityManager.flush();

    }
}
