package error_handling.ex14;


public class OnOffSwitch {
    private static Switch sw = new Switch();
    static Integer[] array = new Integer[1];

    public static void f(int value) throws OnOffException1, OnOffException2 {}

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f(array[0]);
            sw.off();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}