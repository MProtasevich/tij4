package interfaces.ex01;


class Mouse extends Rodent {
    @SuppressWarnings("unused")
    private String description = "Mouse";

    Mouse() {
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

    Gerbil() {
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

    public Hamster() {
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


public abstract class Rodent {
    @SuppressWarnings("unused")
    private String description = "Rodent";

    abstract void run();/* {
        System.out.println("Rodent.run()");
    }*/

    abstract void eat();/* {
        System.out.println("Rodent.eat()");
    }*/

    public static void main(String[] args) {
        Rodent[] rodents = { new Mouse(), new Gerbil(), new Hamster() };

        for(Rodent rodent : rodents) {
            rodent.run();
            rodent.eat();
        }
    }
}