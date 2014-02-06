package concurrency.ex16;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.ex15.ThreadTestF;
import concurrency.ex15.ThreadTestG;
import concurrency.ex15.ThreadTestH;


public class Ex16 {
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