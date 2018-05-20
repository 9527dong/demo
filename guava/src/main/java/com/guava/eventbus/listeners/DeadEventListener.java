package com.guava.eventbus.listeners;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 17:27
 **/
public class DeadEventListener {
    @Subscribe
    public void handle(DeadEvent event){
        System.out.println(event.getSource());
        System.out.println(event.getEvent());
    }
}
