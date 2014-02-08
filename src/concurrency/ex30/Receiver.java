package concurrency.ex30;


import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.concurrent.BlockingQueue;


public class Receiver implements Runnable {
    private BlockingQueue<Character> queue;

    public Receiver(BlockingQueue<Character> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                printnb("Read: " + queue.take() + ", ");
            }
        } catch(InterruptedException ie) {
            print(ie + " Receiver read exception");
        }
    }
}