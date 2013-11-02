package operators.ex10;


public class BitwiseOperators {
    public static void printBinary(int value) {
        System.out.println(Integer.toBinaryString(value));
    }

    public static void main(String[] args) {
        int firstVal = 0xAAAAAAAA;
        int secondVal = 0x55555555;
        printBinary(firstVal);
        printBinary(secondVal);
        printBinary(firstVal & secondVal);
        printBinary(firstVal | secondVal);
        printBinary(firstVal ^ secondVal);
        printBinary(~firstVal);
        printBinary(~secondVal);
    }
}