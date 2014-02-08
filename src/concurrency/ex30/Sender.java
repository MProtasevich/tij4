package concurrency.ex30;


import static net.mindview.util.Print.print;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


public class Sender implements Runnable {
    private Random rand = new Random(47);
    private BlockingQueue<Character> queue = new LinkedBlockingDeque<Character>();

    public Sender(BlockingQueue<Character> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true) {
                for(char c = 'A'; c <= 'z'; ++c) {
                    queue.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(50));
                }
            }
        } catch(InterruptedException e) {
            print(e + " Sender sleep interrupted");
        }
    }
}