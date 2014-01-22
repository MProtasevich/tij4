package generics.ex20;

public class B implements A {

    @Override
    public void f1() {
        System.out.println("B.f1()");
    }

    @Override
    public void f2() {
        System.out.println("B.f2()");
    }
    
    public void f3() {
        System.out.println("B.f3()");
    }
}