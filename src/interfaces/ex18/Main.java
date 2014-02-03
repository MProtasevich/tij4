package interfaces.ex18;


interface Cycle {
    void ride();
}


interface CycleFactory {
    Cycle getCycle();
}


class Unicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Unicycle.ride()");
    }

    void balance() {
        System.out.println("Unicycle.balance()");
    }
}


class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}


class Bicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Bicycle.ride()");
    }

    void balance() {
        System.out.println("Bicycle.balance()");
    }
}


class BicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}


class Tricycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Tricycle.ride()");
    }
}


class TricycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}


public class Main {
    static void rideCycle(CycleFactory cycleFactory) {
        Cycle cycle = cycleFactory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        CycleFactory[] cycleFactories = { new UnicycleFactory(),
                new BicycleFactory(), new TricycleFactory() };

        for(CycleFactory cycleFactory : cycleFactories) {
            rideCycle(cycleFactory);
        }
    }
}