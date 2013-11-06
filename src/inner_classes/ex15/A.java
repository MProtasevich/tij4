package inner_classes.ex15;

public class A {
    A(String string) {
        System.out.println("A(string): " + string);
    }

    public static void main(String[] args) {
        B b = new B();
        b.getA();
    }
}

class B {
    A getA() {
        return new A("message") { };
    }
}