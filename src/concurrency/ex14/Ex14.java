package concurrency.ex14;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class Ex14 {
    public static void main(String[] args) throws Exception {
        int numOfTimers = new Random().nextInt(100) + 1;
        for(int i = 0; i < numOfTimers; i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());
                }
            }, numOfTimers - i);
        }
        // Wait for timers to expire
        TimeUnit.MILLISECONDS.sleep(2 * numOfTimers);
        System.exit(0);
    }
}