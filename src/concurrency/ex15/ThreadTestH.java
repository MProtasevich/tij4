package concurrency.ex15;


public class ThreadTestH implements Runnable {
    private ICriticalSection cs;

    public ThreadTestH(ICriticalSection cs) {
        this.cs = cs;
    }

    @Override
    public void run() {
        cs.h();
    }
}