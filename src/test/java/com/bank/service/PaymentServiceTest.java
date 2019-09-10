package com.bank.service;

import com.bank.model.Payment;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test @Transactional
    public void shouldCreatePayment() {
        Payment draftPayment = new Payment ("John", "Smith", 200, "in progress");
        this.paymentService.save(draftPayment);
        Integer id = draftPayment.getId();

        Payment retrievedPayment = this.paymentService.findById(id);
        Assertions.assertThat(retrievedPayment.getStatus()).isEqualTo("in progress");
        Assertions.assertThat(retrievedPayment.getId()).isNotNull();
    }
}
