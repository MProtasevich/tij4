package concurrency.ex35;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int NUM_OF_SERVERS = 3;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // If line is too long, customers will leave:
        WebClientLine clients = new WebClientLine(MAX_LINE_SIZE);
        WebClientGenerator gen = new WebClientGenerator(clients);
        exec.execute(gen);
        // Manager will add and remove tellers as necessary:
        exec.execute(new ServerManager(exec, gen, clients, ADJUSTMENT_PERIOD,
                NUM_OF_SERVERS));
        if(args.length > 0) { // Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}