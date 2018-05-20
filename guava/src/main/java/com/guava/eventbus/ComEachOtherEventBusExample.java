package com.guava.eventbus;

import com.google.common.eventbus.EventBus;
import com.guava.eventbus.events.Apple;
import com.guava.eventbus.events.Fruit;
import com.guava.eventbus.listeners.FruitEaterListener;
import com.guava.eventbus.service.QueryService;
import com.guava.eventbus.service.RequestQueryHandler;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 14:39
 **/
public class ComEachOtherEventBusExample {
    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        QueryService queryService = new QueryService(eventBus);
        RequestQueryHandler requestQueryHandler = new RequestQueryHandler(eventBus);

        queryService.query("123123");
    }
}
