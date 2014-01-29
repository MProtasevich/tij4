package containers.ex32;


import java.util.ArrayList;
import java.util.List;


public class IntegerArrayTest {
    private static long start, stop;
    static long addTimeTest(IntegerArray sh, int reps) {
        start = System.nanoTime();

        for(int i = 0; i < reps; i++) {
            sh.add(47);
        }

        stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long addTimeTest(ArrayList<Integer> list, int reps) {
        start = System.nanoTime();

        for(int i = 0; i < reps; i++) {
            list.add(47);
        }

        stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(IntegerArray sh, int reps) {
        start = System.nanoTime();

        for(int i = 0; i < reps; i++) {
            sh.get(i);
        }

        stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(ArrayList<Integer> list, int reps) {
        start = System.nanoTime();

        for(int i = 0; i < reps; i++) {
            list.get(i);
        }

        stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long incrementInList(List<Integer> list, int reps) {
        start = System.nanoTime();

        for(int i = 0; i < reps; i++) {
            for(Integer integer : list) {
                ++integer;
            }
        }

        stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long incrementInArray(IntegerArray array, int reps) {
        start = System.nanoTime();

        for(int i = 0; i < reps; ++i) {
            array.incrementAll();
        }

        stop = System.nanoTime();
        return (stop - start) / reps;
    }
}