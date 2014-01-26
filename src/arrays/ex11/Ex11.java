package arrays.ex11;


public class Ex11 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Integer[] classArray = new Integer[3];
        int[] primitiveArray = new int[3];
        // type mismatch
        //primitiveArray = classArray;

        // type mismatch
        //classArray = primitiveArray;
    }
}