package com.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 14:48
 **/
public class BaseListener extends AbstractListener{
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractListener.class);

    @Subscribe
    public void baseTask(final String event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received event [{}] will be handle by {}.{}", new Object[]{event,this.getClass().getSimpleName(),"baseTask"});
        }
    }
}
