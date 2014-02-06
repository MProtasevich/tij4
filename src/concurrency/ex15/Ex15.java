package concurrency.ex15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Ex15 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CriticalSection cs = new CriticalSection();
        for(int i = 0; i < 100; ++i) {
            exec.execute(new ThreadTestF(cs));
            exec.execute(new ThreadTestG(cs));
            exec.execute(new ThreadTestH(cs));
        }
        exec.shutdown();
    }
}