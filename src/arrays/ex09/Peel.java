package arrays.ex09;


public class Peel<T> {
    private T t;
    private static long counter;
    private final long id = counter++;

    public Peel(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Peel " + id + " " + t.toString();
    }
}