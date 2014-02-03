package inner_classes.ex23;

public class A {
    U getU() {
        return new U() {
            @Override
            public void h() {
                System.out.println("U.h()");
            }

            @Override
            public void g() {
                System.out.println("U.g()");
            }

            @Override
            public void f() {
                System.out.println("U.f()");
            }
        };
    }
}