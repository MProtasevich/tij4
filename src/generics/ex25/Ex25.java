package generics.ex25;


public class Ex25 {
    public static <T extends A> void ac(T c) {
        c.a();
    }

    public static <T extends B> void bc(T c) {
        c.b();
    }

    public static void main(String[] args) {
        ac(new C());
        bc(new C());
    }
}