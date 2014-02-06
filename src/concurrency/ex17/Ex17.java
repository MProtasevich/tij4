package concurrency.ex17;


import static net.mindview.util.Print.print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Ex17 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; ++i) {
            exec.execute(new Sensor(i));
        }

        TimeUnit.SECONDS.sleep(4);
        Sensor.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            print("Some tasks were not terminated");
        }
        print("Total: " + Sensor.getTotalCount());
        print("Sum of Sensors: " + Sensor.sumSensors());
    }
}