package containers.ex38;


import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.mindview.util.CountingGenerator;
import net.mindview.util.CountingMapData;
import containers.Test;
import containers.TestParam;
import containers.Tester;


public class Ex38 {
    static List<Test<Map<Integer, String>>> tests = new ArrayList<Test<Map<Integer, String>>>();
    static CountingGenerator.String cgs = new CountingGenerator.String(5);
    static {
        tests.add(new Test<Map<Integer, String>>("put") {
            @Override
            public int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; ++i) {
                    map.clear();
                    for(int j = 0; j < size; ++j) {
                        map.put(j, cgs.next());
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, String>>("get") {
            @Override
            public int test(Map<Integer, String> map, TestParam tp) {
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
        tests.add(new Test<Map<Integer, String>>("iterate") {
            @Override
            public int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; ++i) {
                    Iterator<Map.Entry<Integer, String>> it = map.entrySet()
                            .iterator();
                    while(it.hasNext()) {
                        it.next();
                    }
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<Integer, String>(8, .5f);
        print("map1: " + map1);
        map1.putAll(new CountingMapData(1000));
        print("map1: " + map1);
        HashMap<Integer, String> map2 = new HashMap<Integer, String>(8, .75f);
        print("map2: " + map2);
        map2.putAll(map1);
        print("map2: " + map2);
        HashMap<Integer, String> map3 = new HashMap<Integer, String>(8, .9f);
        print("map3: " + map3);
        map2.putAll(map1);
        print("map3: " + map3);
        if(args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        } else {
            Tester.defaultParams = TestParam.array(10, 1000, 100, 1000, 1000,
                    1000);
        }
        print("Comparative time tests:");
        Tester.run(map1, tests);
        Tester.run(map2, tests);
        Tester.run(map3, tests);
    }
}