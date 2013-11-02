package polymorphism.ex05;


public class Cycle {
    protected int numOfWheels;

    Cycle() {
        numOfWheels = 2;
    }

    void ride() {
        Class<? extends Cycle> clazz = this.getClass();
        System.out.println(clazz.getSimpleName() + ".ride() on " + wheels()
                + " wheels");
    }

    int wheels() {
        return this.numOfWheels;
    }

    static void printRide(Cycle cycle) {
        cycle.ride();
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        Bicycle bicycle = new Bicycle();
        Unicycle unicycle = new Unicycle();
        Tricycle tricycle = new Tricycle();
        Cycle.printRide(cycle);
        Cycle.printRide(unicycle);
        Cycle.printRide(bicycle);
        Cycle.printRide(tricycle);
    }
}


class Unicycle extends Cycle {
    Unicycle() {
        numOfWheels = 1;
    }
    /*
     * void ride() { System.out.println("Unicycle.ride() on " + wheels() +
     * " wheels"); }
     */
}


class Bicycle extends Cycle {
    public Bicycle() {
        numOfWheels = 4;
    }
    /*
     * void ride() { System.out.println("Bicycle.ride() on " + wheels() +
     * " wheels"); }
     */
}


class Tricycle extends Cycle {
    public Tricycle() {
        numOfWheels = 3;
    }
    /*
     * void ride() { System.out.println("Tricycle.ride() on " + wheels() +
     * " wheels"); }
     */
}