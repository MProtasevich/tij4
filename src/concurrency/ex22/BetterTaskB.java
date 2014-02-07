package concurrency.ex22;


public class BetterTaskB implements Runnable {
    private TaskA a;

    public BetterTaskB(TaskA a) {
        this.a = a;
    }

    public synchronized TaskA getA() {
        return a;
    }

    public static BetterTaskB buildBetter(TaskA a) {
        return new BetterTaskB(a);
    }

    @Override
    public synchronized void run() {
        System.out.println("Better a.flag = " + a.isFlag());
        try {
            while(!a.isFlag()) {
                wait();
                a.setFlag(false);
                System.out.println("BetterWait reset a.flag = false");
            }
        } catch(InterruptedException e) {
            System.out.println("BetterWait.run() interrupted");
        }
    }
}