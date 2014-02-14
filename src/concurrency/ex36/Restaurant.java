package concurrency.ex36;


import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class Restaurant implements Runnable {
    private List<WaitPerson> waitPersons = new ArrayList<WaitPerson>();
    private List<Chef> chefs = new ArrayList<Chef>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    final BlockingQueue<OrderTicket> orderTickets = new LinkedBlockingQueue<OrderTicket>();

    public Restaurant(ExecutorService e, int nWaitPersons, int nChefs) {
        exec = e;
        for(int i = 0; i < nWaitPersons; ++i) {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            exec.execute(waitPerson);
        }
        for(int i = 0; i < nChefs; ++i) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // A new group of customers arrive; assign a
                // WaitPerson:
                WaitPerson wp = waitPersons
                        .get(rand.nextInt(waitPersons.size()));
                int nCustomers = rand.nextInt(4) + 1;
                Table t = new Table(wp, nCustomers, exec);
                exec.execute(t);
                TimeUnit.MILLISECONDS.sleep(400 * nCustomers);
            }
        } catch(InterruptedException e) {
            print("Restaurant interrupted");
        }
        print("Restaurant closing");
    }
}