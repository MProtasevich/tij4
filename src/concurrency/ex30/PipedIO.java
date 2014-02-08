package concurrency.ex30;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class PipedIO {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Character> queue = new LinkedBlockingQueue<Character>();
        Sender sender = new Sender(queue);
        Receiver receiver = new Receiver(queue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}