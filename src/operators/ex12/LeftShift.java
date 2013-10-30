package operators.ex12;

public class LeftShift {
	public static void printBinary(int value) {
		System.out.println(Integer.toBinaryString(value));
	}
	public static void main(String[] args) {
		int value = 0xffffff;
		printBinary(value);
		value <<= 1;
		printBinary(value);
		value >>>= 1;
		printBinary(value);
	}
}