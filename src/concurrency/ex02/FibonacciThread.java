package concurrency.ex02;

import generics.ex07.Fibonacci;

public class FibonacciThread implements Runnable {
    private int num;

    public FibonacciThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        Fibonacci fibonacci = new Fibonacci();
        while(num-- != 0) {
            System.out.println(fibonacci.next());
        }
    }
}