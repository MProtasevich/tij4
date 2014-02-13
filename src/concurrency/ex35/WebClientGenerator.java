package concurrency.ex35;


import static concurrency.ex35.BankTellerSimulation.ADJUSTMENT_PERIOD;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class WebClientGenerator implements Runnable {
    private WebClientLine customers;
    volatile int loadFactor = 1;
    private static Random rand = new Random(47);

    public WebClientGenerator(WebClientLine cq) {
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                customers.put(new WebClient(rand.nextInt(ADJUSTMENT_PERIOD)));
                TimeUnit.MILLISECONDS.sleep(ADJUSTMENT_PERIOD / loadFactor);
            }
        } catch(InterruptedException e) {
            System.out.println("ClientGenerator interrupted");
        }
        System.out.println("ClientGenerator terminating");
    }
}