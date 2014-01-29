package containers.ex34;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.RandomGenerator;
import containers.Test;
import containers.TestParam;
import containers.Tester;


public class SetPerformance {
    static RandomGenerator.String rg = new RandomGenerator.String();
    static List<Test<Set<String>>> tests = new ArrayList<Test<Set<String>>>();
    static {
        tests.add(new Test<Set<String>>("add") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    set.clear();
                    for(int j = 0; j < size; j++) {
                        set.add(rg.next());
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for(int i = 0; i < loops; i++) {
                    for(int j = 0; j < span; j++) {
                        set.contains(rg.next());
                    }
                }
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            public int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for(int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while(it.hasNext()) {
                        it.next();
                    }
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<String>(), tests);
        Tester.run(new HashSet<String>(), tests);
        Tester.run(new LinkedHashSet<String>(), tests);
    }
}