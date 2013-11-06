package holding_your_objects.ex19;

import holding_your_objects.ex18.Maps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Sets {
    private static final int SIZE = 10;
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<String>();

        for(int i = 0; i < SIZE; ++i) {
            hashSet.add(Maps.NAMES[i]);
            System.out.println(hashSet);
        }

        System.out.println(hashSet);
        
        Set<String> linkedHashSet = new LinkedHashSet<String>();

        String[] values = new String[hashSet.size()];
        hashSet.toArray(values);
        Arrays.sort(values);

        for(String value : values) {
            linkedHashSet.add(value);
        }

        System.out.println("\n" + linkedHashSet);
    }
}