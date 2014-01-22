package generics.ex20;

public class C {
    public static <T extends A> void f4(T t) {
        t.f1();
        t.f2();
    }
}