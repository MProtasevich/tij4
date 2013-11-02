package reusing_classes.ex23;


public class LoadClass {
    public static void f() {
        new ClassToLoad();
    }

    public static void main(String[] args) {
        LoadClass.f();
    }
}
