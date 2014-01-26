package arrays.ex24;


import java.util.Comparator;

import arrays.ex19.IntClass;


public class IntComparator implements Comparator<IntClass> {
    @Override
    public int compare(IntClass i1, IntClass i2) {
        return i1.getI() - i2.getI();
    }
}