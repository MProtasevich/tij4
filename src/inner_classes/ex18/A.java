package inner_classes.ex18;

public class A {
    public static class B {
        B() {
            System.out.println("B()");
        }
    }

    public static void main(String[] args) {
        /*B b = */new B();
    }
}