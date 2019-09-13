package com.bank.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int paymentNumber) {
        this.rabbitTemplate.convertAndSend("paymentExchange", "paymentStatus",1001);
    }
}
