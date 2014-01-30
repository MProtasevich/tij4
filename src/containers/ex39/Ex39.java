package containers.ex39;


import static net.mindview.util.Print.print;

import java.util.Map;

import net.mindview.util.Countries;
import net.mindview.util.MapData;
import net.mindview.util.RandomGenerator;
import net.mindview.util.RandomGenerator.Integer;


public class Ex39 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        RandomGenerator.Integer rgi = new RandomGenerator.Integer(10000);
        print("Testing map m of <String,String>: the basics:");
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(10));
        print("m: " + m);
        print("m.get(\"CHAD\") " + m.get("CHAD"));
        print("m.size() = " + m.size());
        print("m.capacity() = " + m.capacity());
        print("Testing rehash() for a map m2 of <Integer,Integer>:");
        SimpleHashMap<Integer, Integer> m2 = new SimpleHashMap<Integer, Integer>();
        print("m2: " + m2);
        print("m2.size() = " + m2.size());
        print("m2.capacity() = " + m2.capacity());
        m2.putAll((Map)MapData.map(rgi, rgi, 996));
        print("after m2.putAll(MapData.map(rgi, rgi, 996): ");
        print("m2.size() = " + m2.size());
        print("m2.capacity() = " + m2.capacity());
        m2.putAll((Map)MapData.map(rgi, rgi, 2000));
        print("after m2.putAll(MapData.map(rgi, rgi, 2000): ");
        print("m2.size() = " + m2.size());
        print("m2.capacity() = " + m2.capacity());
        m2.putAll((Map)MapData.map(rgi, rgi, 1500));
        print("after m2.putAll(MapData.map(rgi, rgi, 1500): ");
        print("m2.size() = " + m2.size());
        print("m2.capacity() = " + m2.capacity());
    }
}