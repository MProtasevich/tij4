package concurrency.ex26;


import static net.mindview.util.Print.print;
import concurrency.ex25.Meal;


public class WaitPerson implements Runnable {
    private Restaurant restaurant;
    protected boolean clean = true;
    protected Meal m;

    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null) {
                        wait(); // ... for the chef to produce a meal
                    }
                }
                m = restaurant.meal;
                print("WaitPerson got " + m);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // ready for another
                }
                print("WaitPerson delivered " + m);
                synchronized(restaurant.busBoy) {
                    clean = false;
                    restaurant.busBoy.notifyAll(); // for cleanup
                }
            }
        } catch(InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}