package concurrency.ex33;


import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("unused")
public class GreenhouseController {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    DelayQueue<DelayedTask> tasks = new DelayQueue<DelayedTask>();

    /*
     * public void schedule(Runnable event, long delay) {
     * scheduler.schedule(event, delay, TimeUnit.MILLISECONDS); }
     * 
     * public void repeat(Runnable event, long initialDelay, long period) {
     * scheduler.scheduleAtFixedRate(event, initialDelay, period,
     * TimeUnit.MILLISECONDS); }
     */
    class LightOn extends DelayedTask {
        public LightOn() {
            super();
        }

        public LightOn(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Turning on lights");
            light = true;
        }

        @Override
        public LightOn create(long d) {
            return new LightOn(d);
        }
    }

    class LightOff extends DelayedTask {
        public LightOff() {
            super();
        }

        public LightOff(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Turning off lights");
            light = false;
        }

        @Override
        public LightOff create(long d) {
            return new LightOff(d);
        }
    }

    class WaterOn extends DelayedTask {
        public WaterOn() {
            super();
        }

        public WaterOn(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Turning greenhouse water on");
            water = true;
        }

        @Override
        public WaterOn create(long d) {
            return new WaterOn(d);
        }
    }

    class WaterOff extends DelayedTask {
        public WaterOff() {
            super();
        }

        public WaterOff(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Turning greenhouse water off");
            water = false;
        }

        @Override
        public WaterOff create(long d) {
            return new WaterOff(d);
        }
    }

    class ThermostatNight extends DelayedTask {
        public ThermostatNight() {
            super();
        }

        public ThermostatNight(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }

        @Override
        public ThermostatNight create(long d) {
            return new ThermostatNight(d);
        }
    }

    class ThermostatDay extends DelayedTask {
        public ThermostatDay() {
            super();
        }

        public ThermostatDay(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }

        @Override
        public ThermostatDay create(long d) {
            return new ThermostatDay(d);
        }
    }

    class Bell extends DelayedTask {
        public Bell() {
            super();
        }

        public Bell(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Bing!");
        }

        @Override
        public Bell create(long d) {
            return new Bell(d);
        }
    }

    /*
     * class Terminate extends DelayedTask { public Terminate(long d) {
     * super(d); }
     * 
     * @Override public void run() { System.out.println("Terminating");
     * scheduler.shutdownNow(); // Must start a separate task to do this job, //
     * since the scheduler has been shut down: new Thread() {
     * 
     * @Override public void run() { for(DataPoint d : data) {
     * System.out.println(d); } } }.start(); }
     * 
     * @Override public Terminate create(long d) { return new Terminate(d); } }
     */
    // New feature: data collection
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar d, float temp, float hum) {
            time = d;
            temperature = temp;
            humidity = hum;
        }

        @Override
        public String toString() {
            return time.getTime()
                    + String.format(" temperature: %1$.1f humidity: %2$.2f",
                            temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();
    { // Adjust date to the half hour
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }
    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections
            .synchronizedList(new ArrayList<DataPoint>());

    class CollectData extends DelayedTask {
        public CollectData() {
            super();
        }

        public CollectData(long d) {
            super(d);
        }

        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized(GreenhouseController.this) {
                // Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE,
                        lastTime.get(Calendar.MINUTE) + 30);
                // One in 5 chances of reversing the direction:
                if(rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                // Store previous value:
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if(rand.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection
                        * rand.nextFloat();
                // Calendar must be cloned, otherwise all
                // DataPoints hold references to the same lastTime.
                // For a basic object like Calendar, clone() is OK.
                data.add(new DataPoint((Calendar)lastTime.clone(), lastTemp,
                        lastHumidity));
            }
        }

        @Override
        public CollectData create(long d) {
            return new CollectData(d);
        }
    }

    public class StopController extends DelayedTask {
        private ExecutorService exec;

        public StopController(long delay, ExecutorService e) {
            super(delay);
            exec = e;
        }

        @Override
        public void run() {
            System.out.println("Calling shutdownNow()");
            exec.shutdownNow();
            // need new Thread since others are shut down:
            new Thread() {
                @Override
                public void run() {
                    for(DataPoint d : data)
                        System.out.println(d);
                }
            }.start();
        }

        @Override
        public StopController create(long delay) {
            return new StopController(delay, Executors.newCachedThreadPool());
        }
    }

    public static class GreenhouseGo implements Runnable {
        private DelayQueue<DelayedTask> q;

        public GreenhouseGo(DelayQueue<DelayedTask> q) {
            this.q = q;
        }

        @Override
        public void run() {
            // System.out.println("GreenhouseGo DelayQueue: " + q);
            try {
                while(!Thread.interrupted()) {
                    q.take().run(); // Run task with the current thread
                }
            } catch(InterruptedException e) {
                // Acceptable way to exit
            }
            System.out.println("Finished GreenhouseGo");
        }
    }
}