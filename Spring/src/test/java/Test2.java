public class Test2 {
    public int i, j;

    public void Test2_m(Test2 a) {
        Test2 b = new Test2();
        b.i = 1;
        b.j = 2;
        a = b;
    }

    public void Test2_m1(Test2 a) {
        a.i = 1;
        a.j = 2;
    }

    public static void main(String argv[]) {
        Test2 t = new Test2();
        t.i = 5;
        t.j = 6;
        System.out.println("t.i   =   " + t.i + "   t.j=   " + t.j); //5,6
        t.Test2_m(t);
        System.out.println("t.i   =   " + t.i + "   t.j=   " + t.j); //5,6,a和t都指向了一个对象，而在Test2_m中s又指向了另一个对象，所以对象t不变！！！
        t.Test2_m1(t);
        System.out.println("t.i   =   " + t.i + "   t.j=   " + t.j); //1,2
    }
}