package concurrency.ex04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.ex02.FibonacciThread;


public class Ex04 {
    public static void execute(ExecutorService exec) {
        int num = 5, numOfNum = 10;
        for(int i = 0; i < num; ++i) {
            exec.execute(new FibonacciThread(numOfNum));
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
        execute(Executors.newCachedThreadPool());
        execute(Executors.newFixedThreadPool(3));
        execute(Executors.newSingleThreadExecutor());
    }
}