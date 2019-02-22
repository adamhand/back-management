package com.rabbitmq;

import com.commons.Constant;
import com.redis.RedisOperation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProducerBootstrap {

    @Autowired
    private static RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate){
        ProducerBootstrap.rabbitTemplate = rabbitTemplate;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProducerBootstrap.class);

        MessageProperties properties = new MessageProperties();
        properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        properties.setContentType("UTF-8");

        Message msg = new Message("order information".getBytes(), properties);
        rabbitTemplate.send(Constant.EXCHANGE_NAMES, Constant.ROUTING_KEY, msg);
    }
}
