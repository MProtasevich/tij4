package concurrency.ex36;


import static net.mindview.util.Print.print;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

import enums.ex03.Food;


public class Table implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private final List<Customer> customers;
    private final OrderTicket orderTicket = new OrderTicket(this);
    private final CyclicBarrier barrier;
    private final int nCustomers;
    private final ExecutorService exec;

    public Table(WaitPerson waitPerson, int nCustomers, ExecutorService e) {
        this.waitPerson = waitPerson;
        customers = Collections.synchronizedList(new LinkedList<Customer>());
        this.nCustomers = nCustomers;
        exec = e;
        barrier = new CyclicBarrier(nCustomers + 1, new Runnable() {
            @Override
            public void run() {
                print(orderTicket.toString());
            }
        });
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }

    public void placeOrder(Customer cust, Food food) {
        orderTicket.placeOrder(cust, food);
    }

    @Override
    public void run() {
        Customer customer;
        for(int i = 0; i < nCustomers; ++i) {
            customers.add(customer = new Customer(this, barrier));
            exec.execute(customer);
        }
        try {
            barrier.await();
        } catch(InterruptedException ie) {
            print(this + " interrupted");
            return;
        } catch(BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        waitPerson.placeOrderTicket(orderTicket);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Table: " + id + " served by: "
                + waitPerson + "\n");
        synchronized(customers) {
            for(Customer customer : customers) {
                sb.append(customer.toString() + "\n");
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}