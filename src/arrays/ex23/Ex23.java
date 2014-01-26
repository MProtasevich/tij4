package arrays.ex23;


import java.util.Arrays;
import java.util.Comparator;


public class Ex23 {
    public static void main(String[] args) {
        Integer[] a1 = { 2, 5, 3, 1, 4 };

        Arrays.sort(a1, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });

        System.out.println(Arrays.toString(a1));
    }
}