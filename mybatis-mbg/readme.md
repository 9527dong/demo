`mybatis-generator(mbp)`是一个数据库逆向到代码的工具，`mybatis-generator`有三种用法：命令行、eclipse插件、maven插件。本项目介绍的是第三种通过 maven 插件实现数据库逆向。

对于 `dao`、`mapper`、`model` 全部可以自动生成十分方便。下面说一下基本配置。

## 一、利用maven引入mybatis-generator-maven 插件
只需要在maven工程的pom.xml配置 mybatis-generator-maven 插件即可.
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <artifactId>mybatis-mbg</artifactId>
    <parent>
        <groupId>com.demo</groupId>
        <artifactId>mybatis-parent</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../mybatis-parent</relativePath>
    </parent>
    <dependencies>
        <!-- Mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
        </dependency>

    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.5</version>
                <configuration>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
## 二、添加generatorConfig.xml 文件
按照maven项目的约定规则，将 `generatorConfig.xml` 放到 `rescores` 文件夹中。

`generatorConfig.xml`中需要配置的信息：

1. 数据库驱动
2. 数据库链接URL，用户名、密码
3. 生成模型的包名和位置
4. 生成映射文件的包名和位置
5. 生成DAO的包名和位置
6. 要生成哪些表

## 三、添加init.properties文件
这里的名字是自己定义的，此文件作为参数配置文件，给`generatorConfig.xml`文件提供动态参数。

在generatorConfig.xml通过配置properties 属性引入:
```xml
<properties resource="init.properties"/>
```
引入后`generatorConfig.xml`可以通过`${key}`的方式动态参数加载配置。

对于init.properties 的配置十分简单易懂，主要注意需要配置数据库驱动就可以了。
```properties
#Mybatis Generator configuration
src_project=./src/main/java
resource_project=./src/main/resources
classPath=./src/main/resources/lib/mysql-connector-java-5.1.37-bin.jar

# \\u6570\\u636E\\u5E93\\u8FDE\\u63A5\\u53C2\\u6570
jdbc_driver=com.mysql.jdbc.Driver
jdbc_url=jdbc:mysql://localhost:3380/mybatis?allowMultiQueries=true
jdbc_user=root
jdbc_password=root

# \\u5305\\u8DEF\\u5F84\\u914D\\u7F6E
model.package=com.mybatis.model
dao.package=com.mybatis.dao
xml.mapper.package=com.mybatis.mapper
```
## 四、运行插件生成反向文件
这里需要通过maven命令来运行插件，运行方式有多种，可以通过maven命令行来运行，也可以通过`idea`等工具来运行maven命令。

通过点击`Maven Project`窗口中的

![mark](https://github.com/9527dong/demo/raw/master/mybatis-mbg/src/main/resources/img/maven_run.png)

即可逆向生成代码文件

## 五、参考资料

中文参考：http://mbg.cndocs.tk/index.html

英文官网：http://www.mybatis.org/generator/index.html