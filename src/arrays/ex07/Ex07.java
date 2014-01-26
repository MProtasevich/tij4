package arrays.ex07;

import java.util.Arrays;

import arrays.BerylliumSphere;


public class Ex07 {
    public static BerylliumSphere[][][] createArray(int m, int n, int s) {
        BerylliumSphere[][][] result = new BerylliumSphere[m][n][s];

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                for(int k = 0; k < s; k++) {
                    result[i][j][k] = new BerylliumSphere();
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(createArray(2, 3, 5)));
    }
}