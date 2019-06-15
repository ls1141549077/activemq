package com.github.activemq.producer;

import com.github.activemq.config.ActivemqProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 消息队列生产者 : demo
 */
@Controller
@RequestMapping("/producer")
@Scope("singleton")
public class DemoProducer {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    ActivemqProperty activemqProperty;
    /**
     * 向ActiveMq发送消息
     */
    @GetMapping("/send")
    public void sendMessage(){
        jmsMessagingTemplate.convertAndSend( activemqProperty.getQueueName() , "一条测试消息" + System.currentTimeMillis());
    }


}
