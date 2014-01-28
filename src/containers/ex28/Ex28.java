package containers.ex28;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import containers.ex28.tuple.FiveTuple;
import static containers.ex28.tuple.Tuple.tuple;


public class Ex28 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        FiveTuple<Integer, Integer, Integer, Integer, Integer> t1b =
                tuple(1, 1, 1, 1, 1);
        FiveTuple<Integer, Integer, Integer, Integer, Integer> t2b =
                tuple(1, 1, 1, 2, 1);
        FiveTuple<Integer, Integer, Integer, Integer, Integer> t3b =
                tuple(1, 1, 1, 1, 1);
        FiveTuple<Integer, Integer, Integer, Integer, Integer> t4b = 
                tuple(1, 1, 1, 1, 0);

        System.out.println(t1b.compareTo(t1b));
        System.out.println(t1b.compareTo(t2b));
        System.out.println(t1b.compareTo(t3b));
        System.out.println(t1b.compareTo(t4b));

        List<FiveTuple> list = new ArrayList<FiveTuple>(Arrays.asList(t1b,
                t2b, t3b, t4b));
        Set<FiveTuple> s = new TreeSet<FiveTuple>();
        s.addAll(list);
        System.out.println(s);
    }
}