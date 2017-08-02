User对象和UserService在`dubbo-server`系统和`dubbo-consumer`系统中都使用，那么，我们是否应该讲该代码复用呢？

将`dubbo-server`和`dubbo-consumer`模块中的重复代码提取出来，创建一个`dubbo-server-api`模块。在使用`dubbo-server`和`dubbo-consumer`前，需要执行`maven install`命令来将该模块安装到本地的仓库中。

在使用dubbo时，provider需要将提供服务所需要的java代码（bean、interface等）单独打包成jar提供给consumer使用。
