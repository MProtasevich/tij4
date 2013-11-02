package operators.ex13;


public class Chars {
    public static void printBinChar(char ch) {
        System.out.println(Integer.toBinaryString(Character.digit(ch, 10)));
    }

    public static void main(String[] args) {
        char ch1 = '1';
        char ch2 = 'a';
        printBinChar(ch1);
        printBinChar(ch2);
    }
}