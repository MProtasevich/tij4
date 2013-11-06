package inner_classes.ex21;

public interface A {
    String f();
    static class B {
        public static void printA(A a) {
            a.f();
        }
    }
}