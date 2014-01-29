package containers.ex36;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import containers.Test;
import containers.TestParam;


public class MapPerformance {
    static List<Test<Map<Integer, Integer>>> tests = new ArrayList<Test<Map<Integer, Integer>>>();
    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; ++i) {
                    map.clear();
                    for(int j = 0; j < size; ++j) {
                        map.put(j, j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for(int i = 0; i < loops; ++i) {
                    for(int j = 0; j < span; ++j) {
                        map.get(j);
                    }
                }
                return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            public int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; ++i) {
                    Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                    while(it.hasNext()) {
                        it.next();
                    }
                }
                return loops * map.size();
            }
        });
    }
}