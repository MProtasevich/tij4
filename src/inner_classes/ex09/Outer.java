package inner_classes.ex09;

interface Interface {
    void f();
}

public class Outer {
    Interface getInner() {
        class Inner implements Interface {
            @Override
            public void f() {
                System.out.println("Inner.f()");
            }
        }
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.getInner().f();
    }
}