package containers.ex15;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.TextFile;
import containers.SlowMap;


public class Ex15 {
    public static void main(String[] args) {
        String file = "src/net/mindview/util/SlowMap.java";
        List<String> words = new TextFile(file, "\\W+");
        Set<String> uniqueWords = new TreeSet<String>(words);
        SlowMap<String, Integer> counter = new SlowMap<String, Integer>();

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