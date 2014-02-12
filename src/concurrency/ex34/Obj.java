package concurrency.ex34;


public class Obj {
    private static int count = 0;
    private final int i = count++;

    @Override
    public String toString() {
        return "Obj" + i;
    }
}