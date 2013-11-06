package holding_your_objects.ex25;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.mindview.util.TextFile;


@SuppressWarnings("")
public class Ex25 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> map =
                new LinkedHashMap<String, ArrayList<Integer>>();

        List<String> words = new LinkedList<String>();
        words.addAll(new TextFile(
                "holding_your_objects/ex16/SetOperations.jav", "\\W+"));
        System.out.println("Words in file: " + words);

        int count = 0;
        Iterator<String> itWords = words.iterator();
        while(itWords.hasNext()) {
            String s = itWords.next();
            ++count;

            if(!map.keySet().contains(s)) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                arrayList.add(0, count);
                map.put(s, arrayList);
            } else {
                map.get(s).add(count);
                map.put(s, map.get(s));
            }
        }
        System.out.println("Map of word locations: " + map);
    }
}