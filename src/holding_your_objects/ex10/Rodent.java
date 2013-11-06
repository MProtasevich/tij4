package holding_your_objects.ex10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


class Mouse extends Rodent {
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
    void run() {
        System.out.println("Rodent.run()");
    }

    void eat() {
        System.out.println("Rodent.eat()");
    }

    public static void main(String[] args) {
        Rodent[] rodents = { new Rodent(), new Mouse(), new Gerbil(),
                new Hamster() };

        List<Rodent> list = Arrays.asList(rodents);

        Iterator<Rodent> iterator = list.iterator();
        while(iterator.hasNext()) {
            Rodent rodent = iterator.next();
            rodent.run();
            rodent.eat();
        }
    }
}