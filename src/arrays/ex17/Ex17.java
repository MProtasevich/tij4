package arrays.ex17;

import java.math.BigDecimal;
import java.util.Arrays;

import net.mindview.util.Generated;


public class Ex17 {
    public static void main(String[] args) {
        BigDecimal[] bd = new BigDecimal[3];
        Generated.array(bd, new BigDecimalGenerator());
        System.out.println(Arrays.toString(bd));

        System.out.println(Arrays.toString(
            Generated.array(BigDecimal.class, new BigDecimalGenerator(), 5)));
    }
}