package everithing_is_an_object.ex7;

public class Incrementable {
    static void increment() {
        StaticTest.i++;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Incrementable sf = new Incrementable();
        sf.increment();
        Incrementable.increment();
    }
}
