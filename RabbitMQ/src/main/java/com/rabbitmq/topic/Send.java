package com.rabbitmq.topic;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtil;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        // 消息内容
        String message = "商品删除，id=1003";
        channel.basicPublish(EXCHANGE_NAME, "item.delete", null, message.getBytes());
        System.out.println(" 后台系统： '" + message + "'");

        channel.close();
        connection.close();
    }
}