package com.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import com.guava.eventbus.events.Apple;
import com.guava.eventbus.events.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 15:02
 **/
public class FruitEaterListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(FruitEaterListener.class);

    @Subscribe
    public void eat(Fruit event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Fruit eat[{}]. ", event);
        }
    }
    @Subscribe
    public void eat(Apple event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Apple eat[{}]. ", event);
        }
    }
}
