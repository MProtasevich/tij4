package initialization_and_cleanup.ex19;

public class StringArray {

	public static void stringTest(String... args) {
		for(String item : args) {
			System.out.println(item);
		}
	}
	public static void main(String[] args) {
		stringTest(args);
		stringTest("1, 2, 3");
	}
}