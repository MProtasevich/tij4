package inner_classes.ex01;


public class Outer {
    class Inner {
    }

    Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        @SuppressWarnings("unused")
        Outer.Inner inner = outer.getInner();
    }
}