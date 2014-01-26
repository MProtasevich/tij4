package arrays.ex17;


import java.math.BigDecimal;

import net.mindview.util.Generator;


public class BigDecimalGenerator implements Generator<BigDecimal> {
    private BigDecimal bd = new BigDecimal(0);

    @Override
    public BigDecimal next() {
        bd = bd.add(new BigDecimal(1));
        return bd;
    }
}