package concurrency.ex27;


import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import concurrency.ex25.Meal;


public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    public Chef(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                lock.lock();
                try {
                    while(restaurant.meal != null)
                        condition.await();
                } finally {
                    lock.unlock();
                }
                if(++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                printnb("Order up! ");
                restaurant.waitPerson.lock.lock();
                try {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e) {
            print("chef interrupted");
        }
    }
}