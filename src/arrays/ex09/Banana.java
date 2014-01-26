package arrays.ex09;


public class Banana {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Banana " + id;
    }
}