package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ProxyHandler implements InvocationHandler {
    private Subject subject;
    public ProxyHandler(Subject subject){
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("====before====");
        //定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
        Object result = method.invoke(subject, args);
        System.out.println("====after====");
        return result;
    }
}