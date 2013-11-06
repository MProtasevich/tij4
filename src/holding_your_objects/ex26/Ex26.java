package holding_your_objects.ex26;
import java.util.*;

import net.mindview.util.*;

@SuppressWarnings("")
public class Ex26 {
    public static void main(String[] args) {
        Map<String,ArrayList<Integer>> map =
            new LinkedHashMap<String,ArrayList<Integer>>();
        List<String> words = new LinkedList<String>();
        words.addAll(new TextFile("holding_your_objects/ex16/SetOperations.jav", "\\W+"));
        System.out.println("Words in file: " + words);

        int count = 0;
        Iterator<String> itWords = words.iterator();
        while(itWords.hasNext()) {
            String s = itWords.next();
            ++count;

            if(!map.keySet().contains(s)) {
                ArrayList<Integer> ai = new ArrayList<Integer>();
                ai.add(0, count);
                map.put(s, ai);
            } else {
                map.get(s).add(count);
            }
        }
        System.out.println("\nMap of word locations: " + map);
        // New Map to hold sorted words, keyed by location:
        Map<Integer,String> replay = new TreeMap<Integer,String>();
        Iterator<Map.Entry<String,ArrayList<Integer>>> it = 
            map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String,ArrayList<Integer>> me = it.next();

            for(int i = 0;i < me.getValue().size();i++) {
                replay.put(me.getValue().get(i), me.getKey());
            }
        }

        System.out.println("\nTreeMap of ordered locations, words: " + replay);
        // Display words in order as TreeMap values():
        System.out.println("\nWords in original order: " + replay.values());
    }
}