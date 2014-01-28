package containers.ex19;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.TextFile;
import containers.SimpleHashMap;


public class Ex19 {
    public static void main(String[] args) {
        String file = "src/containers/ex19/Ex19.java";
        List<String> words = new TextFile(file, "\\W+");
        Set<String> uniqueWords = new TreeSet<String>(words);
        SimpleHashMap<String, Integer> counter =
                new SimpleHashMap<String, Integer>();

        for(String uniqueWord : uniqueWords) {
            int count = 0;
            for(String word : words) {
                if(uniqueWord.equals(word)) {
                    ++count;
                }
            }
            counter.put(uniqueWord, count);
        }

        System.out.println(counter);
    }
}