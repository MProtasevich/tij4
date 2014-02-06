package concurrency.ex20;


public class LiftOff extends concurrency.LiftOff {
    protected int countdown = 100;
    @Override
    public void run() {
        while(countDown-- > 0) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted: " + id);
                return;
            }
            System.out.print(status());
            Thread.yield();
        }
    }
}