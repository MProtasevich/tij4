package inner_classes.ex20;

public class C implements A {
    @Override
    public void f() {
        System.out.println("C.f()");
    }

    public static void main(String[] args) {
        new C();
    }
}