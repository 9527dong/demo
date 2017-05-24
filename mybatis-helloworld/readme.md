## 本模块为mybatis框架的HelloWorld
### 1. 简单版HelloWorld
1. 创建一张测试表`user`,并插入了一条测试数据
2. 创建对应的javaBean：`mybatis-helloworld/src/main/java/com/yihaomen/mybatis/model/User.java`
3. 创建mybatis配置文件(`Configuration.xml`)
MyBatis 的全局配置文件包含了影响 MyBatis 行为甚深的设置（settings）和属性（properties）信息、如数据库连接池信息等。指导着MyBatis进行工作,可以通过配置文件获取`sqlSessionFactory`，也可以通过非配置文件的形式进行获取`sqlSessionFactory`
4. sql映射文件(`User.xml`)
映射文件的作用就相当于是定义Dao接口的实现类如何工作。这也是我们使用MyBatis时编写的最多的文件。
5. 测试方法：`com.yihaomen.test.mybatisTest#test`
### 2. 面向接口编程的HelloWorld
1. 创建一个Dao接口:`mybatis-helloworld/src/main/java/com/yihaomen/mybatis/inter/IUserOperation.java`
2. 创建sql映射文件（`UserInterface.xml`）
注意：sql映射文件的`namespace`必须改成接口类的类路径：`com.yihaomen.mybatis.inter.IUserOperation`，这样可以使得mybatis为我们自动创建`IUserOperation`接口的代理类。
3. 测试方法：`com.yihaomen.test.mybatisTest#testInterface`

### 小结
1. SqlSession 的实例 **不是线程安全**的，因此是不能被共享的。
2. SqlSession每次使用完成后**需要正确关闭**，这个关闭操作是必须的
3. SqlSession可以直接调用方法的id进行数据库操作，但是我们一般还是推荐**使用SqlSession获取到Dao接口的代理类**，执行代理对象的方法，可以更安全的进行类型检查操作