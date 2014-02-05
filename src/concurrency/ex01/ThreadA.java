package concurrency.ex01;


public class ThreadA implements Runnable {
    public ThreadA() {
        System.out.println("ThreadA constructor");
    }

    @Override
    public void run() {
        int times = 3;
        for(int i = 0; i < times; ++i) {
            System.out.println("Message from " + this.toString() + ", " + i);
            Thread.yield();
        }
        System.out.println("ThreadA.run() complete");
    }
}