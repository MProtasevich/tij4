package arrays.ex03;


import java.util.Arrays;


public class Ex03 {
    public static double[][] twoDimensional(int m, int n, double start,
            double end) {
        double[][] result = new double[m][n];
        double step = (end - start) / (m * n - 1);
        System.out.println(step + ": " + Math.getExponent(step));

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                result[i][j] = start + step * (n * i + j);
            }
        }

        return result;
    }

    public static void print(double[][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        print(twoDimensional(5, 4, 0.0, 1.0));
        print(twoDimensional(2, 2, -1.0, 1.0));
        print(twoDimensional(3, 4, 0.5, 1.0));
        print(twoDimensional(4, 3, -0.5, 1.0));
        print(twoDimensional(2, 3, -0.5, 0.5));
    }
}