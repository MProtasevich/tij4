package concurrency.ex09;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Ex09 {
    public static void main(String[] args) {
        ExecutorService exec = Executors
                .newCachedThreadPool(new PriorityThreadFactory(
                        Thread.MIN_PRIORITY));
        exec.execute(new SimplePriorities());
        Thread.yield();
        exec.shutdown();

        exec = Executors.newCachedThreadPool(new PriorityThreadFactory(
                Thread.MAX_PRIORITY));
        exec.execute(new SimplePriorities());
        Thread.yield();
        exec.shutdown();
    }
}