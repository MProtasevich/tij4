package arrays.ex20;

import java.util.Arrays;

import arrays.ex19.IntClass;


public class Ex20 {
    public static void main(String[] args) {
        System.out.println(new Object().equals(new Object()));
        int m = 3, n = 4;
        Object[][] a1 = new Object[m][n],
                   a2 = new Object[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                a1[i][j] = new Object();
                a2[i][j] = new Object();
            }
        }
        System.out.println("Object[][]: " + Arrays.deepEquals(a1, a2));

        System.out.println(new IntClass(3).equals(new IntClass(3)));
        IntClass[][] b1 = new IntClass[m][n],
                     b2 = new IntClass[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                b1[i][j] = new IntClass(i);
                b2[i][j] = new IntClass(i);
            }
        }
        System.out.println("IntClass[][]: " + Arrays.deepEquals(b1, b2));
    }
}