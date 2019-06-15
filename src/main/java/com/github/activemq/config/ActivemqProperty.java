package com.github.activemq.config;


import lombok.Data;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * activemq配置类
 */
@Component
@Data
public class ActivemqProperty {
    @Value("${spring.activemq.broker-url}")
    private  String brokerUrl ;
    @Value("${queue-name}")
    private String queueName ;
    @Value("${topic-name}")
    private String topicName;
    @Value("${spring.activemq.user}")
    private String user ;
    @Value("${spring.activemq.password}")
    private String password;


    /**
     * 链接工厂
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        ((ActiveMQConnectionFactory) connectionFactory).setBrokerURL(brokerUrl);
        ((ActiveMQConnectionFactory) connectionFactory).setUserName(user);
        ((ActiveMQConnectionFactory) connectionFactory).setPassword(password);
        return connectionFactory ;
    }

    /**
     * Jmdtempalte初始化
     * @return
     */
    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(connectionFactory());
    }

    /**
     * 初始化jmsMessageTemplate
     * @return
     */
    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(){
        return new JmsMessagingTemplate(connectionFactory());
    }


    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }
    @Bean
    public Queue activemqQueue(){
        return new ActiveMQQueue(queueName);
    }


}
