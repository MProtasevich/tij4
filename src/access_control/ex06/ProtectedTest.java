package access_control.ex06;


public class ProtectedTest {
    protected String str = "Test";
}


class Test {
    public static void print() {
        System.out.println(new ProtectedTest().str);
    }
}