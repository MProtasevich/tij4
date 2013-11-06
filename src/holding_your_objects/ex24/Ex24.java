package holding_your_objects.ex24;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Ex24 {
    public static final String[] NUMBERS = { "zero", "one", "two", "three", "four" };
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        for(int i = NUMBERS.length - 1; i >= 0; --i) {
            map.put(NUMBERS[i], i);
        }

        System.out.println("Map to sort: " + map);

        Map<String, Integer> tempMap = new LinkedHashMap<String, Integer>();
        Set<String> setOfKeys = new TreeSet<String>(map.keySet());
        Iterator<String> it = setOfKeys.iterator();
        while(it.hasNext()) {
            String s = it.next();
            map.remove(s);
            tempMap.put(s, map.get(s));
        }
        setOfKeys.clear();

        Set<String> tempSet = new TreeSet<String>(tempMap.keySet());
        Iterator<String> itTemp = tempSet.iterator();
        while(itTemp.hasNext()) {
            String s = itTemp.next();
            tempMap.remove(s);
            map.put(s, tempMap.get(s));
        }
        tempSet.clear();
        tempMap.clear();

        System.out.println("Sorted map: " + map);
    }
}