package com.bank.service;

import com.bank.model.Payment;
import com.bank.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMessageProducer paymentMessageProducer;

    public void save(Payment payment) {
        this.paymentRepository.save(payment);
    }


    public Payment findById(Integer id) {
        // to be improved
        Payment payment = this.paymentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(""+id));;
        // required because Spring Data returns Optional
        return payment;
    }

    public Payment findByPaymentNumber(Integer paymentNumber) {
        return this.paymentRepository.findByPaymentNumber(paymentNumber);
    }

    @Transactional
    public void markAsDone(int paymentNumber) {
        Payment payment = this.findByPaymentNumber(paymentNumber);
        payment.setStatus("done");
    }

    public void sendMessage(int paymentNumber) {
        this.paymentMessageProducer.send(paymentNumber);
    }
}
