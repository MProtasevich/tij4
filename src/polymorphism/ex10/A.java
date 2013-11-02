package polymorphism.ex10;


public class A {
    void f() {
        System.out.println("A.f()");
        g();
    }

    void g() {
        System.out.println("A.g()");
    }

    public static void main(String[] args) {
        A b = new B();
        b.f();
    }
}


class B extends A {
    @Override
    void g() {
        System.out.println("B.g()");
    }
}