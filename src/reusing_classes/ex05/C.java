package reusing_classes.ex05;


class A {
    A() {
        System.out.println("A");
    }
}


class B {
    B() {
        System.out.println("B");
    }
}


public class C extends A {
    {
        new B();
    }

    public static void main(String[] args) {
        new C();
    }
}
