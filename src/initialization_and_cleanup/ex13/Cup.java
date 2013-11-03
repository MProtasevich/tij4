package initialization_and_cleanup.ex13;


public class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup.f(99); // (1)
    }

    static Cups cups = new Cups(); // (2)
}


class Cups {
    static Cup cup;
    static {
        cup = new Cup(1);
    }

    Cups() {
        System.out.println("Cups()");
    }
}