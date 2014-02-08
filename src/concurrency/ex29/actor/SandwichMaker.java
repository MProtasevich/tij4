package concurrency.ex29.actor;


import static net.mindview.util.Print.print;
import concurrency.ex29.item.Sandwich;
import concurrency.ex29.queue.SandwichQueue;
import concurrency.ex29.queue.ToastQueue;


// Put peanutbuttered and jellied toast together
public class SandwichMaker implements Runnable {
    private int count = 0;
    private ToastQueue jelliedQueue, peanutButteredQueue;
    private SandwichQueue sandwichQueue;

    public SandwichMaker(ToastQueue jellied, ToastQueue peanutButtered,
            SandwichQueue sq) {
        jelliedQueue = jellied;
        peanutButteredQueue = peanutButtered;
        sandwichQueue = sq;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Sandwich s = new Sandwich(jelliedQueue.take(),
                        peanutButteredQueue.take(), count++);
                print(s);
                sandwichQueue.put(s);
            }
        } catch(InterruptedException e) {
            print("SandwichMaker interrupted");
        }
        print("Sandwich maker off");
    }
}