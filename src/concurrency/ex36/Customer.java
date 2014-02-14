package concurrency.ex36;


import static net.mindview.util.Print.print;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.SynchronousQueue;

import enums.ex03.Course;
import enums.ex03.Food;


public class Customer implements Runnable {
    private static int counter;
    private final int id;
    private final CyclicBarrier barrier;
    private final Table table;
    private int nPlates; // Number of plates ordered

    public Customer(Table table, CyclicBarrier barrier) {
        this.table = table;
        this.barrier = barrier;
        synchronized(Customer.class) {
            id = counter++;
        }
    }

    // Only one course at a time can be received:
    private final SynchronousQueue<Plate> placeSetting = new SynchronousQueue<Plate>();

    public void deliver(Plate p) throws InterruptedException {
        // Only blocks if customer is still
        // eating the previous course:
        placeSetting.put(p);
    }

    @Override
    public void run() {
        // First place an order:
        for(Course course : Course.values()) {
            Food food = course.randomSelection();
            table.placeOrder(this, food);
            ++nPlates;
        }
        try {
            barrier.await();
        } catch(InterruptedException ie) {
            print(this + " interrupted while ordering meal");
            return;
        } catch(BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        // Now wait for each ordered plate:
        for(int i = 0; i < nPlates; i++)
            try {
                // Blocks until course has been delivered:
                print(this + "eating " + placeSetting.take());
            } catch(InterruptedException e) {
                print(this + "waiting for meal interrupted");
                return;
            }
        print(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customer " + id + " ";
    }
}