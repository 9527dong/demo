package Singleton;

/**
 * 懒汉式版单例模式的实现
 *
 */
public class SingletonObject2 {
    public static SingletonObject2 instance;

    public SingletonObject2() {
        //empty
    }

    public static SingletonObject2 getInstance() {
        if (instance == null) {
            instance = new SingletonObject2();
        }
        return SingletonObject2.instance;
    }
}
