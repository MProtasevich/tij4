package interfaces.ex06;

import interfaces.ex05.intrface.Interface;

public class ImplInterface implements Interface {
    @Override
    public void f() {
        System.out.println("ImplInterface.f()");
    }

    @Override
    public void g() {
        System.out.println("ImplInterface.g()");
    }

    @Override
    public void h() {
        System.out.println("ImplInterface.h()");
    }

    public static void main(String[] args) {
        Interface interface1 = new ImplInterface();
        interface1.f();
        interface1.g();
        interface1.h();
    }
}