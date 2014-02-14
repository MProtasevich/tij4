package concurrency.ex36;


import static net.mindview.util.Print.print;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class WaitPerson implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final Restaurant restaurant;
    final BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<Plate>();

    public WaitPerson(Restaurant rest) {
        restaurant = rest;
    }

    public void placeOrderTicket(OrderTicket orderTicket) {
        try {
            // Shouldn't actually block because this is
            // a LinkedBlockingQueue with no size limit:
            restaurant.orderTickets.put(orderTicket);
        } catch(InterruptedException e) {
            print(this + " placeOrderTicket interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until a course is ready
                Plate plate = filledOrders.take();
                print(this + "received " + plate + " delivering to "
                        + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch(InterruptedException e) {
            print(this + " interrupted");
        }
        print(this + " off duty");
    }

    @Override
    public String toString() {
        return "WaitPerson " + id + " ";
    }
}