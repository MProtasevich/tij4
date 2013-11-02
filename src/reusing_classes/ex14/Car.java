package reusing_classes.ex14;


//: reusing/Car.java
//Composition with public objects.
class Engine {
    public void start() {}

    public void rev() {}

    public void stop() {}

    public void service() {
        System.out.println("service()");
    }
}


class Wheel {
    public void inflate(int psi) {}
}


class Window {
    public void rollup() {}

    public void rolldown() {}
}


class Door {
    public Window window = new Window();

    public void open() {}

    public void close() {}
}


public class Car {
    public static final int NUMBER_OF_WHEELS = 4;
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[NUMBER_OF_WHEELS];
    public Door left = new Door(), right = new Door(); // 2-door

    public Car() {
        for(int i = 0; i < NUMBER_OF_WHEELS; i++)
            wheel[i] = new Wheel();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.service();
    }
} // /:~