package concurrency.ex29.item;


import static net.mindview.util.Print.print;
import concurrency.ex29.queue.ToastQueue;


// Apply jelly to toast
public class Jellyer implements Runnable {
    private ToastQueue dryQueue, jelliedQueue;

    public Jellyer(ToastQueue dry, ToastQueue jellied) {
        dryQueue = dry;
        jelliedQueue = jellied;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until next piece of toast is available
                Toast t = dryQueue.take();
                t.jelly();
                print(t);
                jelliedQueue.put(t);
            }
        } catch(InterruptedException e) {
            print("Jellyer interrupted");
        }
        print("Jellyer off");
    }
}