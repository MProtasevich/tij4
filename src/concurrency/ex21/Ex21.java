package concurrency.ex21;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Ex21 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        TaskA a = new TaskA();
        TaskB b = new TaskB(a);
        for(int i = 0; i < 100; ++i) {
            exec.execute(a);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("main() sleep interrupted");
            }
            exec.execute(b);
        }
        exec.shutdown();
    }
}