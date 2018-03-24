![image](https://raw.githubusercontent.com/9527dong/demo/master/RabbitMQ/src/main/resources/img/Topic-Exchange.png)

>通配符模式

P：消息的生产者
C：消息的消费者
红色：队列

说明：生产者P发送消息到交换机X，type=topic，交换机根据绑定队列的routing key的值进行通配符匹配；符号#：匹配一个或者多个词lazy.# 可以匹配lazy.irs或者lazy.irs.cor

符号*：只能匹配一个词lazy.* 可以匹配lazy.irs或者lazy.cor
