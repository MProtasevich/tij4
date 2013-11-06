package inner_classes.ex11;

public class Outer {
    private class Inner implements Interface {
        @Override
        public void f() {
            System.out.println("Inner.f()");
        }
    }

    Interface getInner() {
        return new Inner();
    }
}