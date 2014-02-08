package concurrency.ex29.actor;


import static net.mindview.util.Print.print;
import concurrency.ex29.item.Toast;
import concurrency.ex29.queue.ToastQueue;


// Apply peanut butter to taast
public class PeanutButterer implements Runnable {
    private ToastQueue dryQueue, peanutButteredQueue;

    public PeanutButterer(ToastQueue dry, ToastQueue peanutButtered) {
        dryQueue = dry;
        peanutButteredQueue = peanutButtered;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until next piece of toast is available
                Toast t = dryQueue.take();
                t.peanutButter();
                print(t);
                peanutButteredQueue.put(t);
            }
        } catch(InterruptedException e) {
            print("PeanutButterer interrupted");
        }
        print("PeanutButterer off");
    }
}