package inner_classes.ex12;

interface Interface {
    void g();
}

public class PrivateClass {
    private String string = "PrivateClass.f()";

    private void f() {
        System.out.println(string);
    }

    private void h() {
        Interface interface1 = new Interface() {
            @Override
            public void g() {
                PrivateClass.this.f();
                PrivateClass.this.string = "Inner.g()";
                PrivateClass.this.f();
            }
        };
        interface1.g();
    }

    public static void main(String[] args) {
        PrivateClass privateClass = new PrivateClass();
        privateClass.h();
    }
}