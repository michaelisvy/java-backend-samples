package com.bank.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMessageListener {

    @Autowired
    private PaymentService paymentService;

    @RabbitListener(queues = "paymentStatus")
    public void onMessage(int paymentNumber) {
        this.paymentService.markAsDone(paymentNumber);
    }
}