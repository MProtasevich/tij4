package initialization_and_cleanup.ex5_6;

public class Dog {
	public void bark() {
		System.out.println("quiet");
	}

	public void bark(char c) {
		System.out.println("cawcaw");
	}

	public void bark(byte b) {
		System.out.println("barkbark");
	}

	public void bark(short s) {
		System.out.println("slurpslurp");
	}

	public void bark(int i) {
		System.out.println("iyow");
	}

	public void bark(long L) {
		System.out.println("lalala");
	}

	public void bark(float f) {
		System.out.println("fififoofum");
	}

	public void bark(double d) {
		System.out.println("dodo");
	}

	// Ex6
	public void bark(float f, double d) {
		System.out.println("fififoofum-dodo");
	}

	public void bark(double d, float f) {
		System.out.println("dodo-fififoofum");
	}

	public static void main(String[] args) {
		Dog dog = new Dog();
		
		dog.bark();
		dog.bark((byte)0);
		dog.bark('0');
		dog.bark(0.0);
		dog.bark(0.0f);
		dog.bark(0);
		dog.bark(0L);
		dog.bark((short)0);

		//Ex6
		dog.bark(0.0f, 0.0);
		dog.bark(0.0, 0.0f);
	}
}