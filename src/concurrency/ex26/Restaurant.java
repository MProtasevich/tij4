package concurrency.ex26;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.ex25.Meal;


public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    BusBoy busBoy = new BusBoy(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}