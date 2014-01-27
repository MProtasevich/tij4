package containers.ex09;

import java.util.Arrays;
import java.util.TreeSet;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;


public class Ex09 {
    public static void main(String[] args) {
        String[] ar = Generated.array(String.class, new RandomGenerator.String(), 7);
        TreeSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(Arrays.asList(ar));

        System.out.println(Arrays.toString(ar));
        System.out.println(set);
    }
}