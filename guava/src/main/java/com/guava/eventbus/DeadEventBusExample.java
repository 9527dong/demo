package com.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.guava.eventbus.listeners.DeadEventListener;
import com.guava.eventbus.listeners.ExceptionListener;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 15:33
 **/
public class DeadEventBusExample {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus(){
            @Override public String toString() {
                return "DEAD-EVENT-BUS";
            }
        };
        DeadEventListener deadEventListener = new DeadEventListener();
        eventBus.register(deadEventListener);
        eventBus.post("DeadEventListener event");
        eventBus.post("DeadEventListener event");
        eventBus.unregister(deadEventListener);
        eventBus.post("DeadEventListener event");
        eventBus.post("DeadEventListener event");
    }
}
