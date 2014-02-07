package concurrency.ex22;


public class BusyTaskB implements Runnable {
    private TaskA a;

    public BusyTaskB(TaskA a) {
        this.a = a;
    }

    public static BusyTaskB buildBusy(TaskA a) {
        return new BusyTaskB(a);
    }

    public TaskA getA() {
        return a;
    }

    @Override
    public void run() {
        while(true) {
            if(a.isFlag()) {
                a.setFlag(false);
                System.out.println("TaskB.run() flag = false\n");
                break;
            }
        }
    }
}