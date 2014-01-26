package arrays.ex14;


import java.util.Arrays;

import net.mindview.util.CountingGenerator;


public class Ex14 {
    public static void main(String[] args) {
        int size = 3;
        boolean[] bArray = new boolean[size];
        byte[] byArray = new byte[size];
        char[] cArray = new char[size];
        double[] dArray = new double[size];
        float[] fArray = new float[size];
        int[] iArray = new int[size];
        long[] lArray = new long[size];
        short[] sArray = new short[size];

        CountingGenerator.Boolean bGenerator = new CountingGenerator.Boolean();
        for(int i = 0; i < bArray.length; ++i) {
            bArray[i] = bGenerator.next();
        }

        CountingGenerator.Byte byGenerator = new CountingGenerator.Byte();
        for(int i = 0; i < byArray.length; ++i) {
            byArray[i] = byGenerator.next();
        }

        CountingGenerator.Character cGenerator = new CountingGenerator.Character();
        for(int i = 0; i < cArray.length; ++i) {
            cArray[i] = cGenerator.next();
        }

        CountingGenerator.Double dGenerator = new CountingGenerator.Double();
        for(int i = 0; i < dArray.length; ++i) {
            dArray[i] = dGenerator.next();
        }

        CountingGenerator.Float fGenerator = new CountingGenerator.Float();
        for(int i = 0; i < fArray.length; ++i) {
            fArray[i] = fGenerator.next();
        }

        CountingGenerator.Integer iGenerator = new CountingGenerator.Integer();
        for(int i = 0; i < iArray.length; ++i) {
            iArray[i] = iGenerator.next();
        }

        CountingGenerator.Long lGenerator = new CountingGenerator.Long();
        for(int i = 0; i < lArray.length; ++i) {
            lArray[i] = lGenerator.next();
        }

        CountingGenerator.Short sGenerator = new CountingGenerator.Short();
        for(int i = 0; i < sArray.length; ++i) {
            sArray[i] = sGenerator.next();
        }

        System.out.println(Arrays.toString(bArray));
        System.out.println(Arrays.toString(byArray));
        System.out.println(Arrays.toString(cArray));
        System.out.println(Arrays.toString(dArray));
        System.out.println(Arrays.toString(fArray));
        System.out.println(Arrays.toString(iArray));
        System.out.println(Arrays.toString(lArray));
        System.out.println(Arrays.toString(sArray));
    }
}