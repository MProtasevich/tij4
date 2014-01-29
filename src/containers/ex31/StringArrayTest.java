package containers.ex31;


import java.util.ArrayList;


public class StringArrayTest {
    static long addTimeTest(StringArray sh, int reps) {
        long start = System.nanoTime();
        for(int i = 0; i < reps; i++) {
            sh.add("hi");
        }
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long addTimeTest(ArrayList<String> list, int reps) {
        long start = System.nanoTime();
        for(int i = 0; i < reps; i++) {
            list.add("hi");
        }
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(StringArray sh, int reps) {
        long start = System.nanoTime();
        for(int i = 0; i < reps; i++) {
            sh.get(i);
        }
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(ArrayList<String> list, int reps) {
        long start = System.nanoTime();
        for(int i = 0; i < reps; i++) {
            list.get(i);
        }
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }
}