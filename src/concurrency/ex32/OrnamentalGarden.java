package concurrency.ex32;


import static net.mindview.util.Print.print;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch doneLatch = new CountDownLatch(size);

        for(int i = 0; i < size; ++i) {
            exec.execute(new Entrance(i, doneLatch));
        }
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(3);
        Entrance.stopLatch.countDown();
        doneLatch.await();

        exec.shutdown();
        print("Total: " + Entrance.getTotalCount());
        print("Sum of Entrances: " + Entrance.sumEntrances());
    }
}