package interfaces.ex14;

interface A {
    void a1();
    void a2();
}

interface B {
    void b1();
    void b2();
}

interface C {
    void c1();
    void c2();
}

interface ABC extends A, B, C {
    void abc();
}

class ClassToInherit {}

public class Inheritance extends ClassToInherit implements ABC {

    @Override
    public void a1() {
        System.out.println("Inheritance.a1()");
    }

    @Override
    public void a2() {
        System.out.println("Inheritance.a2()");
    }

    @Override
    public void b1() {
        System.out.println("Inheritance.b1()");
    }

    @Override
    public void b2() {
        System.out.println("Inheritance.b2()");
    }

    @Override
    public void c1() {
        System.out.println("Inheritance.c1()");
    }

    @Override
    public void c2() {
        System.out.println("Inheritance.c2()");
    }

    @Override
    public void abc() {
        System.out.println("Inheritance.abc()");
    }

    void printA(A a) {
        a.a1();
        a.a2();
    }

    void printB(B b) {
        b.b1();
        b.b2();
    }

    void printC(C c) {
        c.c1();
        c.c2();
    }

    void printABC(ABC abc) {
        abc.abc();
    }

    public static void main(String[] args) {
        Inheritance inheritance = new Inheritance();
        inheritance.printA(inheritance);
        inheritance.printB(inheritance);
        inheritance.printC(inheritance);
        inheritance.printABC(inheritance);
    }
}