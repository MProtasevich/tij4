package concurrency.ex29.actor;


import static net.mindview.util.Print.print;
import concurrency.ex29.item.Sandwich;
import concurrency.ex29.item.Toast;
import concurrency.ex29.queue.SandwichQueue;


// Consume the toast
public class SandwichEater implements Runnable {
    private SandwichQueue sandwichQueue;
    private int counter = 0;

    public SandwichEater(SandwichQueue sq) {
        sandwichQueue = sq;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Blocks until next piece of toast is available
                Sandwich s = sandwichQueue.take();
                // Verify that the sandwich is coming in order,
                // and that all are jellied and peanutbettered:
                if(s.getId() != counter++
                        || s.getTop().getStatus() != Toast.Status.JELLIED
                        || s.getBottom().getStatus() != Toast.Status.PEANUTBUTTERED) {
                    print(">>>> Error: " + s);
                    System.exit(1);
                } else
                    print("NumNum! " + s);
            }
        } catch(InterruptedException e) {
            print("SandwichEater interruped");
        }
        print("SandwichEater off");
    }
}