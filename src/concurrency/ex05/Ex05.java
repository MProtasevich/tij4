package concurrency.ex05;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Ex05 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        try {
            for(int i = 0; i < 5; ++i) {
                Future<Long> future = exec.submit(new FibonacciCallableSum(i));
                System.out.println(future.get());
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        } catch(ExecutionException e) {
            e.printStackTrace();
        } finally {
            exec.shutdown();
        }
    }
}