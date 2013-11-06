package holding_your_objects.ex04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/*enum StarWars {
    DarthVader(0, "Darth Vader"),
    QuiGonJinn(1, "Qui-Gon Jinn"),
    Yoda(2, "Magister Yoda"),
    ObiWanKenobi(3, "Obi-Wan Kenobi"),
    DarthMaul(4, "Darth Maul"),
    DarthSidius(5, "Darth Sidius");
    
    private final int key;
    private final String character;

    private StarWars(int key, String character) {
        this.key = key;
        this.character = character;
    }

    public int key() {
        return key;
    }

    public String character() {
        return character;
    }
}*/

public class Generator {
    private int key;
    private static final String[] CHARACTERS = { 
        "Darth Vader", "Qui-Gon Jinn", "Magister Yoda",
        "Obi-Wan Kenobi", "Darth Maul", "Darth Sidius"
    };

    public String next() {
        return CHARACTERS[key++ % CHARACTERS.length];
    }

    public void fill(Collection<String> collection, final int size) {
        if(!collection.isEmpty()) {
            System.out.println("Can't fill non-empty collection");
            return;
        }

        for(int i = 0; i < size; ++i) {
            collection.add(this.next());
        }
    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        final int size = 5;

        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        TreeSet<String> treeSet = new TreeSet<String>();

        System.out.println(
            "ArrayList:\t" + arrayList + "\n" +
            "LinkedList:\t" + linkedList + "\n" +
            "HashSet:\t" + hashSet + "\n" +
            "LinkedHashSet\t" + linkedHashSet + "\n" +
            "TreeSet\t" + treeSet);

        generator.fill(arrayList, size);
        generator.fill(linkedList, size);
        generator.fill(hashSet, size);
        generator.fill(linkedHashSet, size);
        generator.fill(treeSet, size);

        System.out.println(
                "ArrayList:\t" + arrayList + "\n" +
                "LinkedList:\t" + linkedList + "\n" +
                "HashSet:\t" + hashSet + "\n" +
                "LinkedHashSet:\t" + linkedHashSet + "\n" +
                "TreeSet:\t" + treeSet);
    }
}