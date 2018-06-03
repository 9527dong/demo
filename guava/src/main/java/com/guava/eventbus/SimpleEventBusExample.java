package com.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.guava.eventbus.listeners.SimpleListener;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 14:28
 **/
public class SimpleEventBusExample {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        //注册Listener
        eventBus.register(new SimpleListener());
        System.out.println("post the simple event.");
        //向订阅者发送消息
        eventBus.post("Simple Event");
    }
}
