package concurrency.ex29.actor;


import static net.mindview.util.Print.print;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import concurrency.ex29.item.Toast;
import concurrency.ex29.queue.ToastQueue;


public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random();

    public Toaster(ToastQueue tq) {
        toastQueue = tq;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                // Make toast
                Toast t = new Toast(count++);
                print(t);
                // Insert into queue
                toastQueue.put(t);
            }
        } catch(InterruptedException e) {
            print("Toaster interrupted");
        }
        print("Toaster off");
    }
}