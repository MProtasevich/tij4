package holding_your_objects.ex20;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.TextFile;

public class Vowels {
    private static HashMap<Character, Integer> vowelsMap = 
            new HashMap<Character, Integer>();
    private static final Character[] VOWELS = {
        'a', 'e', 'i', 'o', 'u', 'y',
        'A', 'E', 'I', 'O', 'U', 'Y'
    };

    static {
        for(int i = 0; i < VOWELS.length; ++i) {
            vowelsMap.put(VOWELS[i], 0);
        }
    }

    static int count(Set<String> words) {
        int count = 0;

        for(String word : words) {
            for(Character character : word.toCharArray()) {
                Integer i = vowelsMap.get(character);
                if(i != null) {
                    vowelsMap.put(character, i+1);
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(
                new TextFile("holding_your_objects/ex16/SetOperations.jav", "\\W+"));

        System.out.println(words);
        System.out.println(vowelsMap);

        System.out.println(count(words));

        System.out.println(vowelsMap);
    }
}