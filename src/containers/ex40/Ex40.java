package containers.ex40;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import net.mindview.util.Generated;


public class Ex40 {
    public static void main(String[] args) {
        int size = 16;
        RandGen.StringClass rg = new RandGen.StringClass();
        StringClass[] array = Generated.array(StringClass.class, rg, size);
        ArrayList<StringClass> arrayList = new ArrayList<StringClass>(
                Arrays.asList(Generated.array(StringClass.class, rg, size)));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Collections.sort(arrayList);
        System.out.println(arrayList);

        SComparator comp = new SComparator();
        Arrays.sort(array, comp);
        System.out.println(Arrays.toString(array));
        Collections.sort(arrayList, comp);
        System.out.println(arrayList);

        System.out.println(Arrays.binarySearch(array, new StringClass(), comp));
        System.out.println(Collections.binarySearch(arrayList,
                new StringClass(), comp));
    }
}