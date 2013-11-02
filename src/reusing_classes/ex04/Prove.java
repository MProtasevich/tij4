package reusing_classes.ex04;


class A {
    A() {
        System.out.println("A");
    }
}


class B extends A {
    B() {
        System.out.println("B");
    }
}


public class Prove {
    public static void main(String[] args) {
        /* B b = */new B();
    }
}
