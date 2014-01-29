package containers.ex30;


import java.util.Collections;
import java.util.List;


public class SortTest {
    public static long measureTheTime(List<Integer> list) {
        long start, end;
        start = System.nanoTime();
        Collections.sort(list);
        end = System.nanoTime();
        return end - start;
    }

    public static long testList(int size, int repeats, ListCreator lc) {
        long time = 0;
        for(int i = 0; i < repeats; ++i) {
            List<Integer> list = lc.createCollection(size);
            time += measureTheTime(list);
        }
        return time / repeats;
    }
}