package concurrency.ex36;


import static net.mindview.util.Print.print;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import enums.ex03.Food;


public class Chef implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random rand = new Random(47);

    public Chef(Restaurant rest) {
        restaurant = rest;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until an order ticket appears:
                OrderTicket orderTicket = restaurant.orderTickets.take();
                List<Order> orders = orderTicket.getOrders();
                synchronized(orders) {
                    for(Order order : orders) {
                        Food requestedItem = order.item();
                        // Time to prepare order:
                        TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                        Plate plate = new Plate(order, requestedItem);
                        order.getOrderTicket().getWaitPerson().filledOrders
                                .put(plate);
                    }
                }
            }
        } catch(InterruptedException e) {
            print(this + " interrupted");
        }
        print(this + " off duty");
    }

    @Override
    public String toString() {
        return "Chef " + id + " ";
    }
}