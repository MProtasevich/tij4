package concurrency.ex10;


import java.util.concurrent.ExecutionException;


public class Ex10 {
    public static void main(String[] args) {
        FibonacciSum fibSum = new FibonacciSum();
        try {
            for(int i = 0; i < 50; ++i) {
                System.out.println("i = " + i + ", " + fibSum.runTask(i).get());
            }
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        } catch(ExecutionException ee) {
            ee.printStackTrace();
        }
    }
}