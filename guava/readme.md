# 简单的一个eventBus
1. create eventbus
2. registered the subscriber
3. post event

# Subscriber
1. subscribe the event
1. inherit listenr ：有继承关系的listener，被调用时父类的listener也会被执行
3. inherit event：有继承关系的event事件

# exception handler
在Listener执行的过程中，如果出现异常，对整个EventBus没有任何影响，只是会打印出异常堆栈信息。

# DeadEvent
 当EventBus发布了一个事件，但是注册的订阅者中没有找到处理该事件的方法，那么EventBus就会把该事件包装成一个DeadEvent事件来重新发布；我们在应用中可以提供如下的事件处理方法来处理DeadEvent。


# Comprehensive practice
1. listener 之间互相通信

总结：
1. subscriber对象是一个普通的类
2. subscribe方法必须被public 和 void 修饰
3. subscribe方法必须仅仅只有一个参数
4. subscribe方法必须添加 @Subscribe 注释。

