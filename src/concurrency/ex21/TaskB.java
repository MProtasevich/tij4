package concurrency.ex21;


import java.util.concurrent.TimeUnit;


public class TaskB implements Runnable {
    private Runnable run;

    public TaskB(Runnable run) {
        this.run = run;
    }

    @Override
    public void run() {
        try { 
            TimeUnit.MILLISECONDS.sleep(2000);
            synchronized(run) {
                System.out.println("TaskB.run(): run.notifyAll()");
                run.notifyAll();
            }
        } catch(InterruptedException e) {
            System.out.println("TaskB sleep interrupted");
        }       
    }
}