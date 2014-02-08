package concurrency.ex29;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import concurrency.ex29.actor.PeanutButterer;
import concurrency.ex29.actor.SandwichEater;
import concurrency.ex29.actor.SandwichMaker;
import concurrency.ex29.actor.Toaster;
import concurrency.ex29.item.Jellyer;
import concurrency.ex29.queue.SandwichQueue;
import concurrency.ex29.queue.ToastQueue;


public class ToastOMatic {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(), jelliedQueue = new ToastQueue(), peanutButteredQueue = new ToastQueue();
        SandwichQueue sandwichQueue = new SandwichQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Jellyer(dryQueue, jelliedQueue));
        exec.execute(new PeanutButterer(dryQueue, peanutButteredQueue));
        exec.execute(new SandwichMaker(jelliedQueue, peanutButteredQueue,
                sandwichQueue));
        exec.execute(new SandwichEater(sandwichQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}