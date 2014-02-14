package concurrency.ex36;


import enums.ex03.Food;


public class Order {
    private static int counter;
    private final int id;
    private volatile OrderTicket orderTicket;
    private final Customer customer;
    private final Food food;

    public Order(Customer cust, Food f) {
        customer = cust;
        food = f;
        synchronized(Order.class) {
            id = counter++;
        }
    }

    void setOrderTicket(OrderTicket orderTicket) {
        this.orderTicket = orderTicket;
    }

    public OrderTicket getOrderTicket() {
        return orderTicket;
    }

    public Food item() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order: " + id + " item: " + food + " for: " + customer;
    }
}