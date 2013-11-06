package holding_your_objects.ex16;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.TextFile;

public class Vowels {
    private static Set<Character> vowelsSet = new HashSet<Character>();

    static {
        Collections.addAll(vowelsSet, 'a', 'e', 'i', 'o', 'u', 'y',
                                      'A', 'E', 'I', 'O', 'U', 'Y');
    }

    static int count(Set<String> words) {
        int count = 0;
        for(String word : words) {
            for(Character character : word.toCharArray()) {
                if(vowelsSet.contains(character)) {
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(new TextFile("SetOperations.jav", "\\W+"));
        count(words);
    }
}