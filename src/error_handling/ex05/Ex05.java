package error_handling.ex05;


public class Ex05 {
    public static void main(String[] args) {
        boolean isRunnable = true;
        int[] array = { 1, 2, 3, 4 };
        int index = 5;
        while(isRunnable) {
            try {
                System.out.println(++array[index]);
                isRunnable = false;
            } catch(ArrayIndexOutOfBoundsException aioobe) {
                aioobe.printStackTrace();
                --index;
            }
        }
    }
}