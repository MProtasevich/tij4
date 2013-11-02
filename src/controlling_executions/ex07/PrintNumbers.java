package controlling_executions.ex07;


public class PrintNumbers {
    public static void printNumbersBreak(int lessThan) {
        for(int i = 0; i < Integer.MAX_VALUE; ++i) {
            System.out.println(i);
            if(i == 99) {
                break;
            }
        }
    }

    public static void printNumbersReturn(int lessThan) {
        for(int i = 0; i < Integer.MAX_VALUE; ++i) {
            System.out.println(i);
            if(i == 99) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        printNumbersBreak(100);
        printNumbersReturn(100);
    }
}
