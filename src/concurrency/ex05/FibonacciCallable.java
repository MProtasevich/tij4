package concurrency.ex05;


import generics.ex07.Fibonacci;

import java.util.concurrent.Callable;


public class FibonacciCallable implements Callable<Integer> {
    private int num;

    public FibonacciCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        int res = 0;
        while(num-- != 0) {
            res += fibonacci.next();
        }
        System.out.println("complete");
        return res;
    }
}