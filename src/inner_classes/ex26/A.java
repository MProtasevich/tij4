package inner_classes.ex26;

public class A {
	class AA {
		AA(int i) {
			System.out.println("AA(): " + i);
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
        B b = new B();
	}
}

class B {
	B() {
		new BB(new A(), 3);
	}

	class BB extends A.AA {
		BB(A a, int i) {
			a.super(i);
			System.out.println("BB(): " + i);
		}
	}
}