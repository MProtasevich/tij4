package inner_classes.ex21;


@SuppressWarnings("")
public class Main implements A {
    public static void main(String[] args) {
        A.B.printA(new Main());
    }

    @Override
    public String f() {
        return "Main.f()";
    }
}