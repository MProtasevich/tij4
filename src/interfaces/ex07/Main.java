package interfaces.ex07;


class Mouse implements Rodent {
    @Override
    public void run() {
        System.out.println("Mouse.run()");
    }

    @Override
    public void eat() {
        System.out.println("Mouse.eat()");
    }
}


class Gerbil implements Rodent {
    @Override
    public void run() {
        System.out.println("Gerbil.run()");
    }

    @Override
    public void eat() {
        System.out.println("Gerbil.eat()");
    }
}


class Hamster implements Rodent {
    @Override
    public void run() {
        System.out.println("Hamster.run()");
    }

    @Override
    public void eat() {
        System.out.println("Hamster.eat()");
    }
}


interface Rodent {
    public void run();
    public void eat();
}

public class Main {
    public static void main(String[] args) {
        Rodent[] rodents = { new Mouse(), new Gerbil(), new Hamster() };
        for(Rodent rodent : rodents) {
            rodent.run();
            rodent.eat();
        }
    }
}