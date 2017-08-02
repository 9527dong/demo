## 需求：
存在2个系统，`dubbo-consumer`系统和`dubbo-server`系统，A系统调用B系统的接口获取数据，用于查询用户列表。
## dubbo-consumer
本模块为dubbo的客户端模块，通过`userServiceTest.testQueryAll()`方法来调用服务端的接口。

> **注意：**
1. 在调用测试方法前，需要先将`dubbo-server-api`模块安装到本地仓库。
2. 在调用测试方法前，需要先启动`dubbo-server`模块。

核心配置文件为`dubbo/dubbo-consumer.xml`。

如测试成功，会打印出类似以下的结果：

```
com.dubbo.pojo.User@69eeaa65
com.dubbo.pojo.User@33f50338
com.dubbo.pojo.User@1aa66c2e
com.dubbo.pojo.User@24084dad
com.dubbo.pojo.User@1d23ab56
com.dubbo.pojo.User@10c5aa0c
com.dubbo.pojo.User@211f026e
com.dubbo.pojo.User@7ad894be
com.dubbo.pojo.User@210d84f4
com.dubbo.pojo.User@7e93c01f
```