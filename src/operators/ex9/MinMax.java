package operators.ex9;

public class MinMax {
	public static void printExpD(double d) {
		System.out.printf("d = %e", d);
	}
	public static void printExpF(float f) {
		System.out.printf("f = %e", f);
	}
	
	public static void main(String[] args) {
		printExpF(Float.MIN_VALUE);
		printExpF(Float.MAX_VALUE);
		printExpD(Double.MIN_VALUE);
		printExpD(Double.MAX_VALUE);
	}
}