package concurrency.ex11;


// Without synchronized you'll get a lot of exceptions
public class EvenNum {
    private int num = 1, even = 2;

    public synchronized void nextNumbers() {
        ++num;
        Thread.yield();
        even += 2;
    }

    public synchronized void check() {
        System.out.println("num = " + num + "; even = " + even);
        if(num * 2 != even) {
            throw new IllegalStateException();
        }
    }
}