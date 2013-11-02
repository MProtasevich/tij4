package initialization_and_cleanup.ex02;


public class StringsTest {
    // Will be initialized before StringsTest()
    String definitionInit = "definitionInit";
    String constructorInit;

    public StringsTest() {
        constructorInit = "constructorInit";
    }

    public static void main(String[] args) {
        StringsTest test = new StringsTest();
        System.out.println(test.definitionInit);
        System.out.println(test.constructorInit);
    }
}