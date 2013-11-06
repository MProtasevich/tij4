package holding_your_objects.ex23;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;


public class Statistics {
    private static final int
        RIGHT_MERGE = 10,
        NUM_OF_TESTS = 200,
        NUM_OF_PICKS = 1000;

    private static int getBestInt(int n) {
        Random rand = new Random();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for(int i = 0; i < n; ++i) {
            int r = rand.nextInt(RIGHT_MERGE);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }

        int max = Collections.max(map.values());

        Set<Map.Entry<Integer, Integer>> me =
               new LinkedHashSet<Map.Entry<Integer, Integer>>(map.entrySet());

        int maxKey = 0;
        Iterator<Map.Entry<Integer, Integer>> it = me.iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, Integer> findMax = it.next();
            if(findMax.getValue() == max) {
                maxKey = findMax.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for(int i = 0; i < NUM_OF_TESTS; i++) {
            int x = getBestInt(NUM_OF_PICKS);
            Integer freq = map.get(x);
            map.put(x, freq == null ? 1 : freq+1);
        }

        System.out.println("Most often picked ints, 0 - 9, in 200 " +
                "tests of 1,000 random picks: " + map);
    }
}