package concurrency.ex19;


import static net.mindview.util.Print.print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        for(int i = 0; i < 5; ++i) {
            exec.execute(new Entrance(i));
        }

        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdownNow();

        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            print("Some tasks were not terminated!");
        }

        print("Total: " + Entrance.getTotalCount());
        print("Sum of Entrances: " + Entrance.sumEntrances());
    }
}