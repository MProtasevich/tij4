package concurrency.ex15;


public class ThreadTestG implements Runnable {
    private ICriticalSection cs;

    public ThreadTestG(ICriticalSection cs) {
        this.cs = cs;
    }

    @Override
    public void run() {
        cs.g();
    }
}