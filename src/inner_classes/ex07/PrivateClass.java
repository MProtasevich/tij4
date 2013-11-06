package inner_classes.ex07;

public class PrivateClass {
    private String string = "PrivateClass.f()";

    private void f() {
        System.out.println(string);
    }

    class Inner {
        public void g() {
            PrivateClass.this.f();
            PrivateClass.this.string = "Inner.g()";
            PrivateClass.this.f();
        }
    }
    
    private void h() {
        Inner inner = new Inner();
        inner.g();
    }

    public static void main(String[] args) {
        PrivateClass privateClass = new PrivateClass();
        privateClass.h();
    }
}