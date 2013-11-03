package access_control.ex05;

class AccessClass {
    public int a = 0;
    int b = 1;
    protected int c = 2;
    private int d = 3;

    public void printA() {
        System.out.println(a);
    }

    void printB() {
        System.out.println(b);
    }

    protected void printC() {
        System.out.println(c);
    }

    @SuppressWarnings("unused")
    private void printD() {
        System.out.println(d);
    }
}

public class Access {
    public static void main(String[] args) {
        AccessClass ac = new AccessClass();

        ac.printA();
        ac.printB();
        ac.printC();
        // ac.printD(); // we can't call private method outside the class

        ac.a = 4;
        ac.b = 5;
        ac.c = 6;
        // ac.d = 7; // we have no access to private fields outside the class
    }
}