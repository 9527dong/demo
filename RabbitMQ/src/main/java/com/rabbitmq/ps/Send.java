package com.rabbitmq.ps;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtil;

//订阅模式
public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息内容
        String message = "商品已经被更新，id=1001";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" 后台系统： '" + message + "'");

        channel.close();
        connection.close();
    }
}