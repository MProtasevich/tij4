package inner_classes.ex10;

interface Interface {
    void f();
}

public class Outer {
    Interface getInner(boolean b) {
        if(b) {
            class Inner implements Interface {
                @Override
                public void f() {
                    System.out.println("Inner.f()");
                }
            }
            return new Inner();
        }
        return null;
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.getInner(true).f();
    }
}