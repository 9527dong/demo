本项目用来测试spring的一些自定义功能。

1. 自定义标签：

2. [FactoryBean](http://chenzehe.iteye.com/blog/1481476)：一般情况下，Spring 通过反射机制利用 <bean> 的 class 属性指定实现类实例化 Bean ，在某些情况下，实例化 Bean 过程比较复杂，如果按照传统的方式，则需要在 <bean> 中提供大量的配置信息。配置方式的灵活性是受限的，这时采用编码的方式可能会得到一个简单的方案。 Spring 为此提供了一个 org.springframework.bean.factory.FactoryBean 的工厂类接口，用户可以通过实现该接口定制实例化 Bean 的逻辑。
在该接口中还定义了以下3 个方法：
* T getObject()：返回由 FactoryBean 创建的 Bean 实例，如果 isSingleton() 返回 true ，则该实例会放到 Spring 容器中单实例缓存池中；

* boolean isSingleton()：返回由 FactoryBean 创建的 Bean 实例的作用域是 singleton 还是 prototype ；

* Class<T> getObjectType()：返回 FactoryBean 创建的 Bean 类型。