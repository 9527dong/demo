![image](https://raw.githubusercontent.com/9527dong/demo/master/RabbitMQ/src/main/resources/img/Direct-Exchange.png)

>路由模式

P：消息的生产者
C：消息的消费者
红色：队列

说明：生产者发送消息到交换机并且要指定路由key，消费者将队列绑定到交换机时需要指定路由key，消费者可以有选择性的接收消息。

测试结果：

1. 同一个消息被多个消费者获取。
2. 在管理工具中查看队列和交换机的绑定关系：
