package com.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.guava.eventbus.events.Apple;
import com.guava.eventbus.events.Fruit;
import com.guava.eventbus.listeners.ConcreteListener;
import com.guava.eventbus.listeners.FruitEaterListener;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 14:39
 **/
public class InheritEventsBusExample {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new FruitEaterListener());
        eventBus.post(new Apple("apple"));

        System.out.println("---------------------");
        eventBus.post(new Fruit("Fruit"));
    }
}
