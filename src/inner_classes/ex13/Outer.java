package inner_classes.ex13;

interface Interface {
    void f();
}

public class Outer {
    Interface getInner() {
        return new Interface() {
            @Override
            public void f() {
                System.out.println("Inner.f()");
            }
        };
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.getInner().f();
    }
}