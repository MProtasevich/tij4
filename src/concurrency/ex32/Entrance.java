package concurrency.ex32;


import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;
    private final CountDownLatch doneLatch;
    public static final CountDownLatch stopLatch = new CountDownLatch(1);


    public Entrance(int id, CountDownLatch doneLatch) {
        this.id = id;
        this.doneLatch = doneLatch;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        entrances.add(this);
    }

    @Override
    public void run() {
        while(stopLatch.getCount() != 0) {
            synchronized(this) {
                ++number;
            }
            print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                print("sleep interrupted");
            }
        }
        print("Stopping " + this);
        doneLatch.countDown();
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for(Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}