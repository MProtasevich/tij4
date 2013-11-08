package error_handling.ex25;


class Exception1 extends Exception {
    private static final long serialVersionUID = 1649438739582196347L;
}


class Exception2 extends Exception1 {
    private static final long serialVersionUID = -6667192816814868318L;
}


class Exception3 extends Exception2 {
    private static final long serialVersionUID = -7055256425659398325L;
}


class A {
    void f() throws Exception1 {
        throw new Exception1();
    }
}


class B extends A {
    @Override
    void f() throws Exception2 {
        throw new Exception2();
    }
}


class C extends B {
    @Override
    void f() throws Exception3 {
        throw new Exception3();
    }
}


public class Ex25 {
    public static void main(String[] args) {
        try {
            A a = new C();
            a.f();
        } catch(Exception3 e) {
            System.out.println("Exception3");
        } catch(Exception2 e) {
            System.out.println("Exception2");
        } catch(Exception1 e) {
            System.out.println("Exception1");
        }
    }
}