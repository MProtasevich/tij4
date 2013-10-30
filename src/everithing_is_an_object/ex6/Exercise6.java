package everithing_is_an_object.ex6;

// Exercise 6: (2) Write a program that includes and calls the storage()
// method defined as a code fragment in this chapter. 
public class Exercise6 {
    int storage(String s) {
        return s.length() << 1;
    }

    public static void main(String[] args) {
        Exercise6 ex6 = new Exercise6();
        String text = "text";
        System.out.printf("storage() return for '" + text + "': ",
                           ex6.storage(text));
    }
}
