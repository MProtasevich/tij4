package everithing_is_an_object.ex01;


// Exercise 1: (2) Create a class containing an int and a char that
// are not initialized, and print their values to verify that Java 
// performs default initialization.
public class Exercise1 {
    int a;
    char b;

    public void printResult() {
        System.out.printf("int value (should be 0) = %d\n", a);
        System.out.printf("char value = %d", b);
    }
}
