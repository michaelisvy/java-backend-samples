package com.bank.repository;

import com.bank.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    Payment findByPaymentNumber(Integer paymentNumber);


}
