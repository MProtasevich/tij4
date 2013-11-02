package reusing_classes.ex07;


class A {
    A(int i) {
        System.out.println("A: " + i);
    }
}


class B {
    B(int i) {
        System.out.println("B: " + i);
    }
}


public class C extends A {
    {
        new B(1);
    }

    C(int i) {
        super(i);
        System.out.println("C: " + i);
    }

    public static void main(String[] args) {
        new C(1);
    }
}
