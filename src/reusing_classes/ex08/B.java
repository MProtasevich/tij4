package reusing_classes.ex08;


class A {
    A(int i) {
        System.out.println("A: " + i);
    }
}


public class B extends A {
    B() {
        super(0);
        System.out.println("B");
    }

    B(int i) {
        super(i);
        System.out.println("B: " + i);
    }
}
