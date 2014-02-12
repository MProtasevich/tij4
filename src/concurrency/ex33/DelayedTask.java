package concurrency.ex33;


import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


public abstract class DelayedTask implements Delayed, Runnable {
    @SuppressWarnings("unused")
    private long delayTime;
    private long trigger;

    public DelayedTask() {
        delayTime = 0;
        trigger = System.nanoTime();
    }

    public DelayedTask(long d) {
        delayTime = d;
        trigger = System.nanoTime() + NANOSECONDS.convert(d, MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        if(delayed instanceof DelayedTask) {
            DelayedTask delayedTask = (DelayedTask)delayed;
            if(trigger > delayedTask.trigger) {
                return 1;
            } else if(trigger < delayedTask.trigger) {
                return -1;
            }
        }
        return 0;
    }

    abstract public DelayedTask create(long d);

    @Override
    abstract public void run();

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
    }
}