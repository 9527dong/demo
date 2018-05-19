package Singleton;

/**
 * 懒汉式版单例模式的实现，使用synchronized加锁
 * 缺点：性能低，getInstance()方法变成了串行化的了
 */
public class SingletonObject3 {
    public static SingletonObject3 instance;

    public SingletonObject3() {
        //empty
    }

    public synchronized static SingletonObject3 getInstance() {
        if (instance == null) {
            instance = new SingletonObject3();
        }
        return SingletonObject3.instance;
    }
}
