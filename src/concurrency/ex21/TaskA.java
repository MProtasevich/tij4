package concurrency.ex21;


public class TaskA implements Runnable {
    private volatile boolean signal = false;

    @Override
    public synchronized void run() {
        try {
            while(!signal) {
                System.out.println("TaskA.run() wait()");
                wait();
                signal = true;
                System.out.println("TaskA is done waiting");
            }
        } catch(InterruptedException e) {
            System.out.println("TaskA run() interrupted");
        } finally {
            System.out.println("Leaving TaskA.run()");
        }
    }
}