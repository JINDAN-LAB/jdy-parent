package com.jindan.jdy.controller.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "boot-active-queue")
    public void receiveMsg(String text) {
        System.out.println("接收到消息 : "+text);
    }

}
