package concurrency.ex28;


import concurrency.LiftOff;


public class LiftOffAdder implements Runnable {
    private LiftOffRunner runner;
    private static final int NUM = 5;

    public LiftOffAdder(LiftOffRunner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        for(int i = 0; i < NUM; ++i) {
            runner.add(new LiftOff(NUM));
        }
    }
}