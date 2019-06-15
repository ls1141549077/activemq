package com.github.activemq;

import com.github.activemq.config.ActivemqProperty;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class ActivemqApplication {


    public static void main(String[] args) {
        SpringApplication.run(ActivemqApplication.class, args);
    }


}
