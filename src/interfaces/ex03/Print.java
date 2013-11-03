package interfaces.ex03;

public abstract class Print {
    public Print() {
        print();
    }

    public abstract void print();

    public static void main(String[] args) {
        new PrintEx().print();
        // base-class constructor would finish it's work before
        // the initialization of i, so first print would be "0".
        // After that, i would be initialized and the second
        // print would be "1"
    }
}

class PrintEx extends Print {
    private int i = 1;

    @Override
    public void print() {
        System.out.println(i);
    }
}