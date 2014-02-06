package concurrency.ex18;


public class Ex18 {
    public static void main(String[] args) {
        SleepNonTask task = new SleepNonTask();
        Thread thread = new Thread(new Task(task));
        thread.start();
        thread.interrupt();
    }
}