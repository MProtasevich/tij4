package arrays.ex21;


import java.util.Arrays;

import arrays.BerylliumSphere;


public class Ex21 {
    public static void main(String[] args) {
        int size = 3;
        BerylliumSphere[] cs1 = new ComparableSphere[size];

        for(int i = 0; i < size; ++i) {
            cs1[i] = new ComparableSphere();
        }

        System.out.println("Created:\n" + Arrays.toString(cs1));
        // Sort in descending order
        Arrays.sort(cs1);
        System.out.println("Sorted:\n" + Arrays.toString(cs1));

        Arrays.sort(cs1, new SphereComparator());
        System.out.println("Reverse sort:\n" + Arrays.toString(cs1));
    }
}