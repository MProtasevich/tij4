package inner_classes.ex08;

public class Outer {
    class Inner {
        private int i = 1;
    }

    void f() {
        Inner inner = new Inner();
        System.out.println(inner.i);
        ++inner.i;
        System.out.println(inner.i);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.f();
    }
}