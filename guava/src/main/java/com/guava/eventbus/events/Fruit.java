package com.guava.eventbus.events;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 15:00
 **/
public class Fruit {
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override public String toString() {
        return "Fruit{" +
            "name='" + name + '\'' +
            '}';
    }
}
