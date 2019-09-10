package com.bank.repository;

import com.bank.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PaymentMessageTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendAndReceiveMessage() {

        produceMessage();
        String message = consumeMessage();

        assertThat(message).isEqualTo("hello message");
    }


    private void produceMessage() {
        this.rabbitTemplate.convertAndSend("hello", "hello message");
    }

    private String consumeMessage() {
        return (String) this.rabbitTemplate.receiveAndConvert("hello");
    }

}
