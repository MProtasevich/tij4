package arrays.ex06;

import java.util.Arrays;

import arrays.BerylliumSphere;


public class Ex06 {
    public static BerylliumSphere[][] createArray(int m, int n) {
        BerylliumSphere[][] result = new BerylliumSphere[m][n];

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; j++) {
                result[i][j] = new BerylliumSphere();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createArray(3, 5)));
    }
}