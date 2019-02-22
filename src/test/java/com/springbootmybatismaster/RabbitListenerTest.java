package com.springbootmybatismaster;

import com.commons.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitListenerTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test(){
        MessageProperties properties = new MessageProperties();
        properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        properties.setContentType("UTF-8");

        Message msg = new Message("order information".getBytes(), properties);
        rabbitTemplate.send(Constant.EXCHANGE_NAMES, Constant.ROUTING_KEY, msg);
    }
}
