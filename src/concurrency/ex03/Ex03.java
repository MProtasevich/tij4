package concurrency.ex03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.ex01.ThreadA;


public class Ex03 {
    public static void execute(ExecutorService exec) {
        int num = 5;
        for(int i = 0; i < num; ++i) {
            exec.execute(new ThreadA());
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
        execute(Executors.newCachedThreadPool());
        System.out.println("\n\n");
        execute(Executors.newFixedThreadPool(2));
        System.out.println("\n\n");
        execute(Executors.newSingleThreadExecutor());
    }
}