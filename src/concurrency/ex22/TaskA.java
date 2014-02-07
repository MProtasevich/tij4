package concurrency.ex22;


import java.util.concurrent.TimeUnit;


public class TaskA implements Runnable {
    private boolean flag = false;

    @Override
    public synchronized void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch(InterruptedException e) {
            System.out.println("TaskA.run() interrupted");
        }
        System.out.println("TaskA.run() flag = true");
        flag = true;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}