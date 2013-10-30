package controlling_executions.ex1;


public class PrintOneHundred {
    public static final int ONE_HUNDRED = 100;

    public static void printOneHundred() {
        for(int i = 0; i < ONE_HUNDRED; ++i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printOneHundred();
    }
}