package concurrency.ex09;


import java.util.concurrent.ThreadFactory;


public class PriorityThreadFactory implements ThreadFactory {
    private int priority;

    public PriorityThreadFactory(int priotity) {
        this.priority = priotity;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(priority);
        return thread;
    }
}