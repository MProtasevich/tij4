package arrays.ex22;

import java.util.Arrays;


public class Ex22 {
    public static void main(String[] args) {
        Integer[] a1 = { 2, 5, 3, 1, 4 };
        int key = 1;
        // WRONG
        System.out.println("a[" + Arrays.binarySearch(a1, key) + "] = " + key);
    }
}