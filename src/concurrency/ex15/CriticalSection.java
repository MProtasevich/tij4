package concurrency.ex15;


public class CriticalSection implements ICriticalSection {
    private int num = 10;

    @Override
    public void f() {
        synchronized(this) {
            for(int i = 0; i < num; ++i) {
                System.out.println("f(): " + i);
                Thread.yield();
            }
            System.out.println();
        }
    }

    @Override
    public void g() {
        synchronized(this) {
            for(int i = 0; i < num; ++i) {
                System.out.println("g(): " + i);
                Thread.yield();
            }
            System.out.println();
        }
    }

    @Override
    public void h() {
        synchronized(this) {
            for(int i = 0; i < num; ++i) {
                System.out.println("h(): " + i);
                Thread.yield();
            }
            System.out.println();
        }
    }
}