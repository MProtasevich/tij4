package concurrency.ex24;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Market {
    ExecutorService exec = Executors.newCachedThreadPool();
    Queue<Item> storage = new LinkedList<Item>();
    Producer producer = new Producer(this);
    Consumer consumer = new Consumer(this);

    public Market() {
        exec.execute(producer);
        exec.execute(consumer);
    }

    public static void main(String[] args) {
        new Market();
    }
}