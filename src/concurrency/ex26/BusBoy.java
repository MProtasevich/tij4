package concurrency.ex26;


import static net.mindview.util.Print.print;


public class BusBoy implements Runnable {
    private Restaurant restaurant;

    public BusBoy(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.waitPerson.clean) {
                        wait();
                    }
                }
                print("BusBoy cleaning up " + restaurant.waitPerson.m);
                restaurant.waitPerson.clean = true;
            }
        } catch(InterruptedException e) {
            print("BusBoy interrupted");
        }
    }
}