本模块介绍一下log4j的使用。
## slf4j、log4j的U币额
### 驱动和桥接
`log4j`是一个日志系统。

`slf4j`是一个日志系统的封装，对外提供统一的API。使用slf4j需要下载
`slf4j-api-x.x.x.jar` 它提供对外一致的API接口，其本身不提供日志实现。

假设我们选择`log4j`作为我们的日志实现，需要下载
`log4j-x.x.x.jar`
如果想把`slf4j`绑定`log4j`，则需要下载slf4j对log4j的相应”驱动”，
`slf4j-log4j12-x.x.x.jar`。
这样就可以使用slf4j提供的API，用log4j实现打日志了。

**所谓驱动** ，就是实现了slf4j的一些接口，用你喜欢的日志系统打日志。

slf4j还支持好多日志系统，并提供了相应的“驱动”包。

例如：
1. `slf4j-jdk14-x.x.x.jar`是为`java.util.logging`提供的驱动
2. `slf4j-simple-x.x.x.jar`直接绑定`System.err`
3. `lf4j-jcl-x.x.x.jar`是为`commons-logging`提供的驱动
4. `logback-classic-x.x.x.jar`是为`logback`提供的驱动

如果你引入了一个第三方jar包或者你之前的工程使用了commons-logging打日志。你想换成slf4j，你不需要更改代码，你需要使用桥接,你可以引入jcl-over-slf4j.jar，同时去掉commons-logging.jar包，这样之前打的日志会自动切换到你的slf4j中来了。同样还有log4j-over-slf4j.jar and jul-to-slf4j.jar等用于使用其它日志系统的应用自动切换到slf4j统一打日志。

