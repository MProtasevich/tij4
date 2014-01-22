package type_information.ex07;

//: typeinfo/SweetShop.java
// Examination of the way the class loader works.
import static net.mindview.util.Print.*;

class Candy {
	static {
		print("Loading Candy");
	}
}

class Gum {
	static {
		print("Loading Gum");
	}
}

class Cookie {
	static {
		print("Loading Cookie");
	}
}

public class SweetShop {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("No args");
		}

		for(String arg : args) {
			try {
				Class<?> c = Class.forName("type_information.ex07." + arg);
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Class " + arg + " not found");
			}
		}
	}
} 