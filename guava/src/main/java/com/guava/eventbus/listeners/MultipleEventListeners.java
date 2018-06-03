package com.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 14:37
 **/
public class MultipleEventListeners {
    private final static Logger LOGGER = LoggerFactory.getLogger(MultipleEventListeners.class);

    @Subscribe
    public void task1(final String event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received event [{}] and will take a action by ==task1==", event);
        }
    }

    @Subscribe
    public void task2(final String event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received event [{}] and will take a action by ==task2==", event);
        }
    }

    /**
     *
     * @param event 此处数据类型必须为Integer，不能是int
     */
    @Subscribe
    public void intTask(final Integer event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received event [{}] and will take a action by ==intTask==", event);
        }
    }
}
