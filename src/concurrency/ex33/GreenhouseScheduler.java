package concurrency.ex33;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GreenhouseScheduler {
    public static void repeat(GreenhouseController c, DelayedTask task,
            long interval, long duration) throws Exception {
        if(interval <= duration) {
            for(int i = 0; i < duration / interval; i++) {
                DelayedTask t = task.create(interval * (i + 1));
                c.tasks.put(t);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        GreenhouseController ghc = new GreenhouseController();
        repeat(ghc, ghc.new Bell(), 1000, 4000);
        repeat(ghc, ghc.new ThermostatNight(), 2000, 4000);
        repeat(ghc, ghc.new LightOn(), 200, 4000);
        repeat(ghc, ghc.new LightOff(), 400, 4000);
        repeat(ghc, ghc.new WaterOn(), 600, 4000);
        repeat(ghc, ghc.new WaterOff(), 800, 4000);
        repeat(ghc, ghc.new ThermostatDay(), 1400, 4000);
        repeat(ghc, ghc.new CollectData(), 500, 4000);
        ghc.tasks.put(ghc.new StopController(5000, exec));
        exec.execute(new GreenhouseController.GreenhouseGo(ghc.tasks));
    }
}