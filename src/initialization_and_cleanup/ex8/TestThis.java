package initialization_and_cleanup.ex8;

public class TestThis {
	public void f() {
		g();
		this.g();
	}
	
	public void g() {
		System.out.println("2nd method.");
	}
}