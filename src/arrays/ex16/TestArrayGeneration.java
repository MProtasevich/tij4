package arrays.ex16;


//: arrays/TestArrayGeneration.java
// Test the tools that use generators to fill arrays.
import static net.mindview.util.Print.print;

import java.util.Arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;


public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = ConvertTo.primitive(Generated.array(Boolean.class,
                new SkipCountingGenerator.Boolean(3), size));
        print("a1 = " + Arrays.toString(a1));

        byte[] a2 = ConvertTo.primitive(Generated.array(Byte.class,
                new SkipCountingGenerator.Byte(2), size));
        print("a2 = " + Arrays.toString(a2));

        char[] a3 = ConvertTo.primitive(Generated.array(Character.class,
                new SkipCountingGenerator.Character(4), size));
        print("a3 = " + Arrays.toString(a3));

        short[] a4 = ConvertTo.primitive(Generated.array(Short.class,
                new SkipCountingGenerator.Short(5), size));
        print("a4 = " + Arrays.toString(a4));

        int[] a5 = ConvertTo.primitive(Generated.array(Integer.class,
                new SkipCountingGenerator.Integer(6), size));
        print("a5 = " + Arrays.toString(a5));

        long[] a6 = ConvertTo.primitive(Generated.array(Long.class,
                new SkipCountingGenerator.Long(7), size));
        print("a6 = " + Arrays.toString(a6));

        float[] a7 = ConvertTo.primitive(Generated.array(Float.class,
                new SkipCountingGenerator.Float(8), size));
        print("a7 = " + Arrays.toString(a7));

        double[] a8 = ConvertTo.primitive(Generated.array(Double.class,
                new SkipCountingGenerator.Double(9), size));
        print("a8 = " + Arrays.toString(a8));
    }
}