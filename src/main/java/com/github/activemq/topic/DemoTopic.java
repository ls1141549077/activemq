package com.github.activemq.topic;

import com.github.activemq.config.ActivemqProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Topic;

@Controller
@RequestMapping("/activemq")
public class DemoTopic {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    ActivemqProperty activemqProperty;
    @Autowired
    Topic topic;



    @RequestMapping("/topic")
    public void topic(){
        jmsMessagingTemplate.convertAndSend(topic,"这是一条广播信息:"+System.currentTimeMillis());
    }



}
