HttpClient是Apache Jakarta Common下的子项目，用来提供高效的、最新的、功能丰富的支持HTTP协议的客户端编程工具包，并且它支持HTTP协议最新的版本和建议。HttpClient已经应用在很多的项目中，比如Apache Jakarta上很著名的另外两个开源项目Cactus和HTMLUnit都使用了HttpClient。
本模块介绍了httpclient的各种demo：
1. Get请求 - com.http.DoGET
2. 带有参数的Get请求 - com.http.DoGETParam
3. POST请求 - com.http.DoPOST
4. 带有参数的POST请求 - com.http.DoPOSTParam
5. 介绍httpclient的连接管理器 - com.http.HttpConnectManager
6. 使用线程定期关闭无效的连接 - com.http.ClientEvictExpiredConnections
7. httpclient设置请求配置参数 - com.http.RequestConfigDemo