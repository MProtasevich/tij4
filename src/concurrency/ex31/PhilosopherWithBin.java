package concurrency.ex31;


import static net.mindview.util.Print.print;

import java.util.concurrent.BlockingQueue;

import concurrency.Chopstick;
import concurrency.Philosopher;


public class PhilosopherWithBin extends Philosopher {
    protected BlockingQueue<Chopstick> bin;

    public PhilosopherWithBin(Chopstick left, Chopstick right, int ident,
            int ponder, BlockingQueue<Chopstick> bin) {
        super(left, right, ident, ponder);
        this.bin = bin;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                print(this + " " + "thinking");
                pause();
                // Philosopher becomes hungry
                print(this + " " + "grabbing right");
                setRight(bin.take());
                print(this + " " + "grabbing left");
                setLeft(bin.take());
                print(this + " " + "eating");
                pause();
                bin.put(getLeft());
                bin.put(getRight());
            }
        } catch(InterruptedException e) {
            print(this + " " + "exiting via interrupt");
        }
    }
}