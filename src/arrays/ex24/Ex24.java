package arrays.ex24;

import java.util.Arrays;

import arrays.ex19.IntClass;


public class Ex24 {
    public static void main(String[] args) {
        IntClass[] a1 = { new IntClass(5), new IntClass(2), new IntClass(4),
                          new IntClass(3), new IntClass(1)};
        IntClass key = new IntClass(2);

        IntComparator comparator = new IntComparator();
        System.out.println(Arrays.toString(a1));
        Arrays.sort(a1, comparator);
        System.out.println(Arrays.toString(a1));

        System.out.println("a1[" + Arrays.binarySearch(a1, key, comparator) + "] = " + key);
    }
}