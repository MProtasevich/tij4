package concurrency;


import static net.mindview.util.Print.print;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);

    protected void pause() throws InterruptedException {
        if(ponderFactor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    protected Chopstick getLeft() {
        return left;
    }

    protected void setLeft(Chopstick left) {
        this.left = left;
    }

    protected Chopstick getRight() {
        return right;
    }

    protected void setRight(Chopstick right) {
        this.right = right;
    }

    public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
        this.left = left;
        this.right = right;
        id = ident;
        ponderFactor = ponder;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                print(this + " " + "thinking");
                pause();
                // Philosopher becomes hungry
                print(this + " " + "grabbing right");
                right.take();
                print(this + " " + "grabbing left");
                left.take();
                print(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch(InterruptedException e) {
            print(this + " " + "exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}