package com.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.guava.eventbus.listeners.ExceptionListener;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 15:33
 **/
public class ExceptionEventBusExample {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus((exception,context) -> {
            System.out.println(context.getEvent());//Exception event
            System.out.println(context.getEventBus());//defalut
            System.out.println(context.getSubscriber());//ExceptionListener
            System.out.println(context.getSubscriberMethod());//m3
        });
        eventBus.register(new ExceptionListener());
        eventBus.post("Exception event");
    }
}
