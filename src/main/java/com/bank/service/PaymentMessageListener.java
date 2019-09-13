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

    @RabbitListener(queues = "paymentStatus2")
    public void onMessage2(int paymentNumber) {
        System.err.println("!!!!RECEIVED2!!!!!");
    }

    @RabbitListener(queues = "paymentStatus3")
    public void onMessage3(int paymentNumber) {
        System.err.println("!!!!RECEIVED3!!!!!");
    }

    @RabbitListener(queues = "paymentStatus4")
    public void onMessage4(int paymentNumber) {
        System.err.println("!!!!RECEIVED4!!!!!");
    }
}