package operators.ex11;


public class RightShift {
    public static void printBinary(int value) {
        System.out.println(Integer.toBinaryString(value));
    }

    public static void main(String[] args) {
        int value = 0xffffff;
        for(int i = 0; i < Integer.SIZE; ++i) {
            printBinary(value >>= 1);
        }
    }
}