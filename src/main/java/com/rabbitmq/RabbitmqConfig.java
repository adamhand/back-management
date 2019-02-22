package com.rabbitmq;

import com.commons.Constant;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class RabbitmqConfig {
    @Bean
    public CachingConnectionFactory connectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost(Constant.IPADDRESS);
        factory.setPort(Constant.PORT);
        factory.setVirtualHost(Constant.VIRTUALHOST);
        factory.setUsername(Constant.USERNAME);
        factory.setPassword(Constant.PASSWORD);

        factory.setAutomaticRecoveryEnabled(true);
        factory.setNetworkRecoveryInterval(1000);

        Map<String, Object> propertiesMap = new HashMap<>();
        propertiesMap.put("prindipal", "adamhand");
        propertiesMap.put("description", "Order System");
        propertiesMap.put("email", "adaihand@163.com");
        factory.setClientProperties(propertiesMap);

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(factory);

        return cachingConnectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(CachingConnectionFactory factory){
        return new RabbitAdmin(factory);
    }

    /**
     * 用于RabbitMQ消息的发送和接收
     * @param factory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory factory){
        return new RabbitTemplate(factory);
    }

    /**
     * 自动声明队列
     * @return
     */
    @Bean
    public Exchange exchange(){
        return new DirectExchange(Constant.EXCHANGE_NAMES, true, false,
                new HashMap<String, Object>());
    }

    @Bean
    public Binding binding(){
        return new Binding(Constant.QUEUE_NAMES, Binding.DestinationType.QUEUE,
                Constant.EXCHANGE_NAMES, Constant.ROUTING_KEY, new HashMap<String, Object>());
    }

    /**
     * 监听容器 为消息入队提供异步处理
     * @param factory
     * @return
     */
//    @RabbitListener(queues = Constant.QUEUE_NAMES)
//    @Bean
    public MessageListenerContainer messageListenerContainer(CachingConnectionFactory factory){
        SimpleMessageListenerContainer msgLIstenerContainer = new SimpleMessageListenerContainer();
        msgLIstenerContainer.setConnectionFactory(factory);
        msgLIstenerContainer.setQueueNames(Constant.QUEUE_NAMES);

        /**
         * 设置消费者线程数和最大线程数
         */
        msgLIstenerContainer.setConcurrentConsumers(Constant.CONSUMER_NUMBER);
        msgLIstenerContainer.setMaxConcurrentConsumers(Constant.MAX_CONSUMER_NUMBER);

        /**
         * 设置消费者属性
         */
        Map<String, Object> argsMap = new HashMap<>();
        msgLIstenerContainer.setConsumerArguments(argsMap);

        /**
         * 设置消费者标签
         */
        msgLIstenerContainer.setConsumerTagStrategy(new ConsumerTagStrategy() {
            @Override
            public String createConsumerTag(String s) {
                return "Consumers of Order System";
            }
        });

        /**
         * 消息后置处理器。接收到消息之后打印出来。
         */
        msgLIstenerContainer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    System.out.println(new String(message.getBody(), "UTF-8"));
//                    System.out.println(message.getMessageProperties());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

        return msgLIstenerContainer;
    }
}
