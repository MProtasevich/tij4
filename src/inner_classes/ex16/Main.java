package inner_classes.ex16;


interface Cycle {
    void ride();
}


interface CycleFactory {
    Cycle getCycle();
}


class Unicycle implements Cycle {
    public static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };

    public void ride() {
        System.out.println("Unicycle.ride()");
    }

    void balance() {
        System.out.println("Unicycle.balance()");
    }
}


class Bicycle implements Cycle {
    public static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };

    public void ride() {
        System.out.println("Bicycle.ride()");
    }

    void balance() {
        System.out.println("Bicycle.balance()");
    }
}


class Tricycle implements Cycle {
    public static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };

    public void ride() {
        System.out.println("Tricycle.ride()");
    }
}


@SuppressWarnings("")
public class Main {
    static void rideCycle(CycleFactory cycleFactory) {
        Cycle cycle = cycleFactory.getCycle();
        cycle.ride();
    }

    public static void main(String[] args) {
        CycleFactory[] cycleFactories = { Unicycle.cycleFactory,
                Bicycle.cycleFactory, Tricycle.cycleFactory };

        for(CycleFactory cycleFactory : cycleFactories) {
            rideCycle(cycleFactory);
        }
    }
}