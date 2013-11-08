package error_handling.ex03;

public class Ex03 {
    public static void main(String[] args) {
        try {
            int[] array = { 1, 2 };
            ++array[5];
        } catch(ArrayIndexOutOfBoundsException aioobe) {
            aioobe.printStackTrace();
        }
    }
}