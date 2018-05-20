package com.guava.eventbus.events;

/**
 * @Description:
 * @Author: Dong.Wang
 * @Date: 2018-05-19 18:03
 **/
public class Request {
    private final String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public Request(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override public String toString() {
        return "Request{" +
            "orderNo='" + orderNo + '\'' +
            '}';
    }
}
