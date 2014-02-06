package concurrency.ex15;


public class ThreadTestF implements Runnable {
    private ICriticalSection cs;

    public ThreadTestF(ICriticalSection cs) {
        this.cs = cs;
    }

    @Override
    public void run() {
        cs.f();
    }
}