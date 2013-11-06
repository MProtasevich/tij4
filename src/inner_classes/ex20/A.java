package inner_classes.ex20;

public interface A {
    void f();
    static class B {
        void g() {
            System.out.println("B.g()");
        }
    }
}