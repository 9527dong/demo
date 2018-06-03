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
        //获取事件源
        System.out.println(event.getSource());//DEAD-EVENT-BUS
        //获取事件
        System.out.println(event.getEvent());//DeadEventListener event
    }
}
