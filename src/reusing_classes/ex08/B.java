package reusing_classes.ex08;


public class B extends A {
    public B() {
        super(0);
        System.out.println("B");
    }

    public B(int i) {
        super(i);
        System.out.println("B: " + i);
    }
}
