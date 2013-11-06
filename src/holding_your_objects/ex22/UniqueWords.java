package holding_your_objects.ex22;


import java.util.*;
import net.mindview.util.*;


class Word {
    static int totalWords = 0;
    String s;
    int count;

    Word(String s, int count) {
        this.s = s;
        this.count = count;
        totalWords++;
    }

    public String toString() {
        return s + ": " + count;
    }
}


public class UniqueWords {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(new TextFile(
                "SetOperations.java", "\\W+"));

        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Words to count, sorted: " + words);

        Set<Word> wordObjects = new HashSet<Word>();
        Iterator<String> it = words.iterator();
        while(it.hasNext()) {
            String s = it.next();
            int count = 0;
            for(int i = 0; i < words.size(); i++) {
                if(s.equals(words.get(i)))
                    count++;
            }
            Word w = new Word(s, count);
            wordObjects.add(w);
        }

        System.out.println("\nWord count: " + wordObjects);
        System.out.println("\nTotal words: " + Word.totalWords);
    }
}