package com.bank.service;

import com.bank.model.Payment;
import com.bank.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public void save(Payment payment) {
        this.paymentRepository.save(payment);
    }



    public Payment findById(Integer id) {
        // to be improved
        Optional<Payment> payment = this.paymentRepository.findById(id);
        return payment.get();
    }
}
