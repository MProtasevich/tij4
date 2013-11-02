package reusing_classes.ex13;


class Ancestor {
    void f(boolean b) {
        System.out.println("boolean: " + b);
    }

    void f(char ch) {
        System.out.println("char: " + ch);
    }

    void f(int i) {
        System.out.println("int: " + i);
    }
}


public class Overloading extends Ancestor {
    void f(String s) {
        System.out.println("String: " + s);
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.f(true);
        overloading.f('a');
        overloading.f(0);
        overloading.f("Abracadabra");
    }
}