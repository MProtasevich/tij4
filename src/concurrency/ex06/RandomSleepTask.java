package concurrency.ex06;


import java.util.Random;
import java.util.concurrent.TimeUnit;


public class RandomSleepTask implements Runnable {
    @Override
    public void run() {
        Random rand = new Random();
        int sleepTime = rand.nextInt(10) + 1;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
            System.out.println(sleepTime);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}