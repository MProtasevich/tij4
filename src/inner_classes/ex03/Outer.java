package inner_classes.ex03;

public class Outer {
    private String string;

    class Inner {
        @Override
        public String toString() {
            return string;
        }
    }

    public Outer() {
        string = "Outer()";
    }

    Inner getInner() {
        return new Inner();
    }
    
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();
        System.out.println(inner);
    }
}