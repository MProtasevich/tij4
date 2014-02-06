package concurrency.ex17;


import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Sensor implements Runnable {
    private static RadCount count = new RadCount();
    private static List<Sensor> sensors = new ArrayList<Sensor>();
    private int number = 0;

    private final int id;
    private static volatile boolean canceled = false;

    // Atomic operation on a volatile field:
    public static void cancel() {
        canceled = true;
    }

    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }

    @Override
    public void run() {
        while(!canceled) {
            synchronized(this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch(InterruptedException e) {
                print("sleep interrupted");
            }
        }
        print("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumSensors() {
        int sum = 0;
        for(Sensor sensor : sensors) {
            sum += sensor.getValue();
        }
        return sum;
    }
}