package generics.ex25;


public class C implements A, B {
    @Override
    public void a() {
        System.out.println("C.a()");
    }

    @Override
    public void b() {
        System.out.println("C.b()");
    }
}