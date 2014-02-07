package concurrency.ex24;


public class Producer implements Runnable {
    private int count = 0;
    Market market;

    Producer(Market m) {
        market = m;
    }

    protected int getCount() {
        return count;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                while(count < 100) {
                    Item item = new Item(++count);
                    if(market.storage.offer(item)) {
                        System.out.println("Produced " + item);
                        synchronized(market.consumer) {
                            market.consumer.notifyAll();
                        }
                    }
                    synchronized(this) {
                        while(!(market.storage.size() < 10)) {
                            wait();
                        }
                    }
                }
                System.out.println("Produced " + count + " Items"
                        + "\nStopping production");
                market.exec.shutdownNow();
            } catch(InterruptedException e) {
                System.out.println("Producer interrupted");
                System.out.println("Produced " + count + " Items");
            }
        }
    }
}