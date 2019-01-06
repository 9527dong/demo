package Proxy;

class RealSubject implements Subject{
    public void request(){
        System.out.println("====RealSubject Request====");
    }
}