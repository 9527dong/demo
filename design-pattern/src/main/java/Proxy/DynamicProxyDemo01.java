package Proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo01 {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        //1.创建委托对象
        ProxyHandler handler = new ProxyHandler(realSubject);
        //2.创建调用处理器对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(), handler);
        //4.通过代理对象调用方法
        proxySubject.request();
    }
}