package interfaces.ex05;

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
}