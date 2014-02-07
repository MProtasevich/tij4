package concurrency.ex22;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Ex22 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        BusyTaskB busy = BusyTaskB.buildBusy(new TaskA());
        exec.execute(busy.getA());
        exec.execute(busy);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            System.out.println("sleep interrupted in main()");
        }
        System.out.println();
        BetterTaskB better = BetterTaskB.buildBetter(new TaskA());
        exec.execute(better.getA());
        exec.execute(better);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            System.out.println("sleep interrupted in main()");
        }
        synchronized(better) {
            System.out.println("Sending better.notifyAll()");
            better.notifyAll();
        }
        exec.shutdownNow();
    }
}