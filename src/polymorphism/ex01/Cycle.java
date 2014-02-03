package polymorphism.ex01;


public class Cycle {
    void ride() {
        System.out.println("Cycle.ride()");
    }

    static void printRide(Cycle cycle) {
        cycle.ride();
    }

    public static void main(String[] args) {
        Cycle[] cycles = { new Unicycle(), new Bicycle(), new Tricycle() };

        for(Cycle cycle : cycles) {
            Cycle.printRide(cycle);
        }
    }
}


class Unicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Unicycle.ride()");
    }
}


class Bicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Bicycle.ride()");
    }
}


class Tricycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Tricycle.ride()");
    }
}
