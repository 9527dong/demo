package com.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.guava.eventbus.listeners.ConcreteListener;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 14:39
 **/
public class InheritListenersEventBusExample {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new ConcreteListener());
        System.out.println("post the string event.");
        eventBus.post("I am String event");
        System.out.println("post the int event.");
        eventBus.post(1000);
    }
}
