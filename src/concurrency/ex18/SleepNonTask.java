package concurrency.ex18;


public class SleepNonTask {
    public void sleep(int time) {
        try {
            Thread.sleep(time * 10);
        } catch(InterruptedException e) {
            System.out.println("Sleep interupted");
        } finally {
            System.out.println("sleep() exit");
        }
    }
}