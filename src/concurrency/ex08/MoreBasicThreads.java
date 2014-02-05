package concurrency.ex08;


import concurrency.LiftOff;


public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}