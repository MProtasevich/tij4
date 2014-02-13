package concurrency.ex35;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public class ServerManager implements Runnable {
    private ExecutorService exec;
    private WebClientGenerator gen;
    private WebClientLine webClients;
    private Queue<Server> servers = new LinkedList<Server>();
    private int adjustmentPeriod;
    private boolean stable = true;
    private int prevSize;

    public ServerManager(ExecutorService e, WebClientGenerator gen,
            WebClientLine clients, int adjustmentPeriod, int n) {
        exec = e;
        this.gen = gen;
        this.webClients = clients;
        this.adjustmentPeriod = adjustmentPeriod;
        // Start with a single teller:
        for(int i = 0; i < n; ++i) {
            Server teller = new Server(clients);
            exec.execute(teller);
            servers.add(teller);
        }
    }

    public void adjustLoadFactor() {
        // This is actually a control system. By adjusting
        // the numbers, you can reveal stability issues in
        // the control mechanism.
        // If line is too long, add another teller:
        if(webClients.size() > prevSize) {
            // If tellers are on break or doing
            // another job, bring one back:
            if(stable) {
                stable = false;
            } else {
                System.out.println("Peak load factor: " + gen.loadFactor);
                exec.shutdownNow();
            }
        } else {
            System.out.println("New load factor: " + ++gen.loadFactor);
            stable = true;
        }
        prevSize = webClients.size();
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                System.out.print(webClients + " { ");
                for(Server server : servers) {
                    System.out.print(server.shortString() + " ");
                }
                System.out.println("}");
                adjustLoadFactor();
            }
        } catch(InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    @Override
    public String toString() {
        return "ServerManager ";
    }
}