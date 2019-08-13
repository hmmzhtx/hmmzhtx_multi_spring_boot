package com.myylm.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.queue.name}")
    private String queueName;

    /**
     * 创建发送消息的方法
     */
    public void send(String msg){
        rabbitAmqpTemplate.convertAndSend(queueName,msg);
    }

}
