package controlling_executions.ex09;


public class Fibonacci {
    public static void printFibonacci(int value) {
        int previousValue = 1, currentValue = 1;
        while(currentValue < value) {
            System.out.print(previousValue + ", ");
            currentValue += previousValue;
            previousValue = currentValue - previousValue;
        }
        System.out.println(currentValue);
    }

    public static void main(String[] args) {
        printFibonacci(100);
    }
}