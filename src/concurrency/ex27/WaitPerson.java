package concurrency.ex27;


import static net.mindview.util.Print.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class WaitPerson implements Runnable {
    private Restaurant restaurant;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                lock.lock();
                try {
                    while(restaurant.meal == null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                print("waitPerson got " + restaurant.meal);
                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll();
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch(InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}