package concurrency.ex17;


public class RadCount {
    private int count = 0;

    public synchronized int increment() {
        return count++;
    }

    public synchronized int value() {
        return count;
    }
}