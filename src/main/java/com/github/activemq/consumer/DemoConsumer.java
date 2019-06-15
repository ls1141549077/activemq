package com.github.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;

@Controller
public class DemoConsumer {

    @JmsListener(destination = "${queue-name}")
    public void receviceQueueMessage(String text){
        System.out.println("我消费了队列消息:" + text);
    }


    @JmsListener(destination = "${topic-name}")
    public void receviceTopicMessage(String text){
        System.out.println("我消费了广播消息:" + text);
    }

}
