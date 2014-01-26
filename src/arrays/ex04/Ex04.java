package arrays.ex04;


import java.util.Arrays;


public class Ex04 {
    public static double[][][] twoDimensional(int m, int n, int s,
            double start, double end) {
        double[][][] result = new double[m][n][s];
        double step = (end - start) / (m * n * s - 1);

        System.out.println(step + ": " + Math.getExponent(step));

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                for(int k = 0; k < s; ++k) {
                    result[i][j][k] = start + step * (n * s * i + j * s + k);
                }
            }
        }

        return result;
    }

    public static void print(double[][][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        print(twoDimensional(2, 3, 4, 0.0, 1.0));
        print(twoDimensional(3, 4, 5, -0.5, 1.0));
        print(twoDimensional(2, 2, 5, -1.0, 1.0));
        print(twoDimensional(1, 3, 7, -1.0, 0.5));
        print(twoDimensional(3, 3, 9, -0.5, 0.5));
    }
}