package concurrency.ex18;


public class Task implements Runnable {
    private SleepNonTask task;

    public Task(SleepNonTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.sleep(50);
    }
}