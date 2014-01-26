package arrays.ex12;


import java.util.Arrays;

import net.mindview.util.CountingGenerator;


public class Ex12 {
    public static void main(String[] args) {
        CountingGenerator.Double doubleGen = new CountingGenerator.Double();
        double[] array = new double[5];
        for(int i = 0; i < array.length; ++i) {
            array[i] = doubleGen.next();
        }
        System.out.println(Arrays.toString(array));
    }
}