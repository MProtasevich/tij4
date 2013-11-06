package inner_classes.ex23;

public class A {
    U getU() {
        return new U() {
            public void h() {
                System.out.println("U.h()");
            }

            public void g() {
                System.out.println("U.g()");
            }

            public void f() {
                System.out.println("U.f()");
            }
        };
    }
}