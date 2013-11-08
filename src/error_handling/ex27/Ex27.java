package error_handling.ex27;


public class Ex27 {
    public static void main(String[] args) {
        try {
            int[] array = { 1, 2 };
            ++array[5];
        } catch(ArrayIndexOutOfBoundsException aioobe) {
            throw new RuntimeException(aioobe);
        }
    }
}