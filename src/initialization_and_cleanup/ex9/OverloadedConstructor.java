package initialization_and_cleanup.ex9;

public class OverloadedConstructor {
	public OverloadedConstructor() {
		this(true);
	}

	public OverloadedConstructor(boolean b) {
		System.out.println(b);
	}
}