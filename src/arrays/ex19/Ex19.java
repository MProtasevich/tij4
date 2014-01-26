package arrays.ex19;

import java.util.Arrays;


public class Ex19 {
    public static void main(String[] args) {
        int size = 3;
        IntClass[] a1 = new IntClass[size],
                   a2 = new IntClass[size];

        for(int i = 0; i < size; ++i) {
            a1[i] = new IntClass(i);
            a2[i] = new IntClass(i);
        }

        System.out.println(Arrays.equals(a1, a2));
    }
}