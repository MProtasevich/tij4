package concurrency.ex35;


import java.util.concurrent.TimeUnit;


public class Server implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    // Customers served during this shift:
    // private int customersServed = 0;
    private WebClientLine webClients;
    //private boolean servingCustomerLine = true;

    public Server(WebClientLine cq) {
        webClients = cq;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                WebClient webClient = webClients.take();
                TimeUnit.MILLISECONDS.sleep(webClient.getServiceTime());
                /*synchronized(this) {
                    customersServed++;
                    while(!servingCustomerLine) {
                        wait();
                    }
                }*/
            }
        } catch(InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    /*public synchronized void doSomethingElse() {
        customersServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert !servingCustomerLine : "already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }*/

    @Override
    public String toString() {
        return "Server " + id + " ";
    }

    public String shortString() {
        return "T" + id;
    }

    /*// Used by priority queue:
    @Override
    public synchronized int compareTo(Server other) {
        return customersServed < other.customersServed ? -1
                : (customersServed == other.customersServed ? 0 : 1);
    }*/
}