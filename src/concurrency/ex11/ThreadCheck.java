package concurrency.ex11;


public class ThreadCheck implements Runnable {
    private EvenNum evenOdd;

    public ThreadCheck(EvenNum evenOdd) {
        this.evenOdd = evenOdd;
    }
    @Override
    public void run() {
        int num = 100;
        while(num-- > 0) {
            evenOdd.nextNumbers();
            evenOdd.check();
        }
    }
}