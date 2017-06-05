## 本模块详细介绍了mybatis框架中的参数传递
### 单个参数
mybatis不会做特殊处理，
	#{参数名/任意名}：取出参数值。
	
### 多个参数
mybatis会做特殊处理。
	多个参数会被封装成 一个map，
		key：param1...paramN,或者参数的索引也可以
		value：传入的参数值
	#{}就是从map中获取指定的key的值；
	
	异常：
	org.apache.ibatis.binding.BindingException: 
	Parameter 'id' no****t found. 
	Available parameters are [1, 0, param1, param2]
	操作：
		方法：public Employee getEmpByIdAndLastName(Integer id,String lastName);
		取值：#{id},#{lastName}

### 命名参数
明确指定封装参数时map的key；@Param("id")
多个参数会被封装成 一个map，
		key：使用@Param注解指定的值
		value：参数值
{指定的key}取出对应的参数值
### POJO
当这些参数属于我们业务POJO时，我们直接传递POJO
### Map
我们也可以封装多个参数为map，直接传递
### # 与 $ 区别
**&#35;{key}：** 解析为一个 JDBC 预编译语句（prepared statement）的参数标记符。预编译到SQL中。安全。

**${key}：** ${ } 仅仅为一个纯碎的 string 替换，在动态 SQL 解析阶段将会进行变量替换。有SQL注入问
题。 ORDER BY ${name}。

**用法：**

1. 能使用 #{ } 的地方就用 #{ }
2. 表名作为变量时，必须使用 ${ }

参考文章：[mybatis深入理解(一)之 # 与 $ 区别以及 sql 预编译](https://segmentfault.com/a/1190000004617028)