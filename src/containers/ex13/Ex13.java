package containers.ex13;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.TextFile;


public class Ex13 {
    public static void main(String[] args) {
        String file = "src/containers/ex13/AssociativeArray.java";
        List<String> words = new TextFile(file, "\\W+");
        Set<String> uniqueWords = new TreeSet<String>(words);
        AssociativeArray<String, Integer> counter =
                new AssociativeArray<String, Integer>(uniqueWords.size());

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