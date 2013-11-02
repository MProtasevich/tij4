package reusing_classes.ex01;


public class SecondClass {
    SimpleClass simpleClass;

    public static void main() {
        SecondClass secondClass = new SecondClass();
        secondClass.simpleClass = new SimpleClass();
    }
}