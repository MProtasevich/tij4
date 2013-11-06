package holding_your_objects.ex21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.mindview.util.TextFile;


public class Sort {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(new TextFile(
                "holding_you_objects/ex16/SetOperations.jav", "\\W+"));

        System.out.println("Words to count: " + words);

        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
        Iterator<String> it = words.iterator();
        int totalWords = 0;
        while(it.hasNext()) {
            String s = it.next();
            Integer count = wordCount.get(s);

            if(count != null) {
                wordCount.put(s, count+1);
                totalWords++;
            }
        }

        System.out.println("\nWord count: " + wordCount);
        System.out.println("\nTotal words: " + totalWords);
    }
}