package concurrency.ex10;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import concurrency.ex05.FibonacciCallableSum;


public class FibonacciSum {
    public Future<Long> runTask(int num) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Long> res = exec.submit(new FibonacciCallableSum(num));
        exec.shutdown();
        return res;
    }
}