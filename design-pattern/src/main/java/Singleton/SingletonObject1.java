package Singleton;

/**
 * 饿汉式版单例模式的实现
 */
public class SingletonObject1 {
    public static SingletonObject1 instance = new SingletonObject1();

    public SingletonObject1() {
        //empty
    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
