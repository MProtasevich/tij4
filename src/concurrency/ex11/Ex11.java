package concurrency.ex11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Ex11 {
    public static void main(String[] args) {
        EvenNum evenOdd = new EvenNum();
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 1000; ++i) {
            exec.execute(new ThreadCheck(evenOdd));
        }
        exec.shutdown();
    }
}