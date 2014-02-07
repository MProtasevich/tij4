package concurrency.ex24;


import java.util.ArrayList;
import java.util.List;


class Consumer implements Runnable {
    int consumed = 0;
    Market market;
    List<Item> cart = new ArrayList<Item>();

    Consumer(Market m) {
        market = m;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Cannot consume more Items than produced:
                synchronized(this) {
                    while(!(cart.size() < market.producer.getCount())) {
                        wait();
                    }
                }
                // Move Item from storage to cart:
                if(cart.add(market.storage.poll())) {
                    System.out.println("Consuming Item " + ++consumed);
                    // Notify producer - ready for more:
                    synchronized(market.producer) {
                        market.producer.notifyAll();
                    }
                }
            }
        } catch(InterruptedException e) {
            System.out.println("Consumer interrupted");
            System.out.println("Consumed " + consumed + " Items");
        }
    }
}