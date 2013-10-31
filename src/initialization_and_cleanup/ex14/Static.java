package initialization_and_cleanup.ex14;

public class Static {
	static String str1 = "definition init";
	static String str2;
	static {
		System.out.println("static: " + str1);
		str2 = "static block init";
		System.out.println("static: " + str2);
	}
	
	public static void demo() {
		System.out.println(str1);
		System.out.println(str2);
	}
}
