package concurrency.ex09;


public class SimplePriorities implements Runnable {
    private int countDown = 5;
    @SuppressWarnings("unused")
    private volatile double d; // No optimization

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        for(int i = 1; i < 100000; i++) {
            d += (Math.PI + Math.E) / (double)i;
            if(i % 1000 == 0) {
                Thread.yield();
            }
        }
        System.out.println(this);
        if(--countDown == 0) {
            return;
        }
    }
}