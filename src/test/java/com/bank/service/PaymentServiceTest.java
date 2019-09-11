package com.bank.service;

import com.bank.model.Payment;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PaymentService paymentService;

    @Test @Transactional
    public void shouldCreatePayment() {
        Payment draftPayment = new Payment ("John", "Smith", 200, "in progress");
        this.paymentService.save(draftPayment);
        Integer id = draftPayment.getId();

        Payment retrievedPayment = this.paymentService.findById(id);
        assertThat(retrievedPayment.getStatus()).isEqualTo("in progress");
    }

    @Test
    public void shouldRetrievePayment() {
        Payment payment = this.paymentService.findByPaymentNumber(1001);
        assertThat(payment.getFirstName()).isEqualTo("Jack");
    }

    @Test @Transactional
    public void shouldUpdatePayment() {
        this.paymentService.markAsDone(1001);

        Payment payment = this.paymentService.findByPaymentNumber(1001);
        assertThat(payment.getStatus()).isEqualTo("done");
    }
}
