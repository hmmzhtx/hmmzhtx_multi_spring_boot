package com.myylm.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    /**
     * 接收消息的方法，采用消息队列监听机制
     * @param msg
     */
    @RabbitListener(queues = "${mq.queue.name}")
    public void process(String msg){
        System.out.println("recevier:"+msg);
    }

}
