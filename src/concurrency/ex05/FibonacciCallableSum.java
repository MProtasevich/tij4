package concurrency.ex05;


import generics.ex07.Fibonacci;

import java.util.concurrent.Callable;


public class FibonacciCallableSum implements Callable<Long> {
    private int num;

    public FibonacciCallableSum(int num) {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        long res = 0;
        while(num-- != 0) {
            res += fibonacci.next();
        }
        System.out.println("complete");
        return res;
    }
}