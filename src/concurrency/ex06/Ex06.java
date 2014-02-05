package concurrency.ex06;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Ex06 {
    public static void main(String[] args) {
        int num = 0;

        if(args.length == 0) {
            num = new Random().nextInt(10) + 1;
        } else {
            num = Integer.parseInt(args[0]);
        }
        System.out.println("Num of tasks: " + num);

        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < num; ++i) {
            exec.execute(new RandomSleepTask());
        }
        exec.shutdown();
    }
}