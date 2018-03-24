![image](https://raw.githubusercontent.com/9527dong/demo/master/RabbitMQ/src/main/resources/img/publish-Subscribe.png)

>订阅模式

P：消息的生产者
C：消息的消费者
红色：队列

解读：

1. 1个生产者，多个消费者
2. 每一个消费者都有自己的一个队列
3. 生产者没有将消息直接发送到队列，而是发送到了交换机
4. 每个队列都要绑定到交换机
5. 生产者发送的消息，经过交换机，到达队列，实现，一个消息被多个消费者获取的目的


测试结果：

1. 同一个消息被多个消费者获取。
2. 在管理工具中查看队列和交换机的绑定关系：
