package controlling_executions.ex05;


public class TernaryOperator {
    public static void printBinary(int value) {
        int testValue = 0x80000000;
        for(int i = 0; i < Integer.SIZE; ++i) {
            System.out.println((value & testValue) == 0 ? "1" : "0");
            testValue >>>= 1;
        }
    }

    public static void main(String[] args) {
        int firstVal = 0xaaaaaa;
        int secondVal = 0x555555;
        printBinary(firstVal);
        printBinary(secondVal);
        printBinary(firstVal & secondVal);
        printBinary(firstVal | secondVal);
        printBinary(firstVal ^ secondVal);
        printBinary(~firstVal);
        printBinary(~secondVal);
    }
}
