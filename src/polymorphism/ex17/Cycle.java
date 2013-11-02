package polymorphism.ex17;


public class Cycle {
    void ride() {
        System.out.println("Cycle.ride()");
    }

    static void printRide(Cycle cycle) {
        cycle.ride();
    }

    public static void main(String[] args) {
        Cycle[] cycles = { new Unicycle(), new Bicycle(), new Tricycle() };

        // can't call balance() because that method wasn't
        // declared in the base class
        /*for(Cycle cycle : cycles) {
            cycle.balance();
        }*/
        ((Unicycle)cycles[0]).balance();
        ((Bicycle)cycles[1]).balance();
    }
}


class Unicycle extends Cycle {
    void ride() {
        System.out.println("Unicycle.ride()");
    }

    void balance() {
        System.out.println("Unicycle.balance()");
    }
}


class Bicycle extends Cycle {
    void ride() {
        System.out.println("Bicycle.ride()");
    }

    void balance() {
        System.out.println("Bicycle.balance()");
    }
}


class Tricycle extends Cycle {
    void ride() {
        System.out.println("Tricycle.ride()");
    }
}