package polymorphism.ex14;


class Mouse extends Rodent {
    @SuppressWarnings("unused")
    private String description = "Mouse";

    Mouse(Shared shared) {
        super(shared);
        System.out.println("Mouse()");
    }

    @Override
    void run() {
        System.out.println("Mouse.run()");
    }

    @Override
    void eat() {
        System.out.println("Mouse.eat()");
    }
}


class Gerbil extends Rodent {
    @SuppressWarnings("unused")
    private String description = "Gerbil";

    Gerbil(Shared shared) {
        super(shared);
        System.out.println("Gerbil()");
    }

    @Override
    void run() {
        System.out.println("Gerbil.run()");
    }

    @Override
    void eat() {
        System.out.println("Gerbil.eat()");
    }
}


class Hamster extends Rodent {
    @SuppressWarnings("unused")
    private String description = "Hamster";

    public Hamster(Shared shared) {
        super(shared);
        System.out.println("Hamster()");
    }

    @Override
    void run() {
        System.out.println("Hamster.run()");
    }

    @Override
    void eat() {
        System.out.println("Hamster.eat()");
    }
}


public class Rodent {
    private Shared shared;
    private static int counter = 0;
    private final int id = counter++;

    @SuppressWarnings("unused")
    private String description = "Rodent";

    public Rodent(Shared shared) {
        System.out.println("Rodent(): " + id);
        this.shared = shared;
        this.shared.addRef();
    }

    void run() {
        System.out.println("Rodent.run()");
    }

    void eat() {
        System.out.println("Rodent.eat()");
    }

    public static void main(String[] args) {
        Shared shared = new Shared();
        Rodent[] rodents = { new Rodent(shared), new Mouse(shared),
                             new Gerbil(shared), new Hamster(shared) };

        for(Rodent rodent : rodents) {
            rodent.run();
            rodent.eat();
        }
    }
}