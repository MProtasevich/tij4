package containers.ex36;


import static net.mindview.util.Print.print;
import static containers.ex36.MapPerformance.tests;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

import net.mindview.util.Countries;
import containers.TestParam;
import containers.Tester;


public class Ex36 {
    public static void main(String[] args) {
        if(args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        } else {
            Tester.defaultParams = TestParam.array(10, 100, 50, 50, 100, 20);
        }

        print("Tesing SlowMap36a:");
        SlowMapA<String, String> m = new SlowMapA<String, String>();
        m.putAll(Countries.capitals(15));
        print("m: " + m);
        print("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
        print("m.entrySet(): " + m.entrySet());
        print("m.keySet(): " + m.keySet());
        print("m.values() = " + m.values());
        print("Two different maps: ");
        SlowMapA<String, String> m2 = new SlowMapA<String, String>();
        print("m.equals(m2): " + m.equals(m2));
        m2.putAll(Countries.capitals(15));
        print("Maps with same entries: ");
        print("m.equals(m2): " + m.equals(m2) + "\n");

        print("Testing SlowMap36b:");
        SlowMapB<String,String> m3 = new SlowMapB<String,String>();
        m3.putAll(Countries.capitals(15));
        print("m3: " + m3);
        print("m3.get(\"BURUNDI\"): " + m3.get("BURUNDI"));
        print("m3.entrySet(): " + m3.entrySet());
        print("m3.hashEntryList(): " + m3.hashEntryList());
        m3.clear();
        print("After m.clear(), m.isEmpty(): " + m.isEmpty() + ", m = " + m);
        m2.keySet().clear();
        print("After m2.keySet().clear(), m2.isEmpty(): " + m2.isEmpty()
                + ", m2 = " + m2 + "\n");

        print("Comparative time tests:");
        Tester.run(new SlowMapA<Integer, Integer>(), tests);
        Tester.run(new containers.ex17.SlowMap<Integer, Integer>(), tests);
        Tester.run(new SlowMapA<Integer, Integer>(), tests);
        Tester.run(new SlowMapB<Integer, Integer>(), tests);
        Tester.run(new HashMap<Integer, Integer>(), tests);
        Tester.run(new TreeMap<Integer, Integer>(), tests);
        Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
        Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
        Tester.run(new WeakHashMap<Integer, Integer>(), tests);
        Tester.run(new Hashtable<Integer, Integer>(), tests);
    }
}
