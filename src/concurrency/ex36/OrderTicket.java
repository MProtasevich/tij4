package concurrency.ex36;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import enums.ex03.Food;


public class OrderTicket {
    private static int counter;
    private final int id = counter++;
    private final Table table;
    private final List<Order> orders = Collections
            .synchronizedList(new LinkedList<Order>());

    public OrderTicket(Table table) {
        this.table = table;
    }

    public WaitPerson getWaitPerson() {
        return table.getWaitPerson();
    }

    public void placeOrder(Customer cust, Food food) {
        Order order = new Order(cust, food);
        orders.add(order);
        order.setOrderTicket(this);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Ticket: " + id + " for: "
                + table + "\n");
        synchronized(orders) {
            for(Order order : orders)
                sb.append(order.toString() + "\n");
        }
        // Prune away the last added 'new-line' character
        return sb.substring(0, sb.length() - 1).toString();
    }
}