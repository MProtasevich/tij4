package holding_your_objects.ex11;

import holding_your_objects.ex04.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    public static void print(Collection<? extends Object> collection) {
        Iterator<? extends Object> it = collection.iterator();
        collection.getClass();
        System.out.print(collection.getClass().getSimpleName() + ": " +
                            (it.hasNext() ? it.next() : null));

        while(it.hasNext()) {
            System.out.print(", " + it.next());
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        final int size = 5;

        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        TreeSet<String> treeSet = new TreeSet<String>();

        print(arrayList);
        print(linkedList);
        print(hashSet);
        print(linkedHashSet);
        print(treeSet);

        generator.fill(arrayList, size);
        generator.fill(linkedList, size);
        generator.fill(hashSet, size);
        generator.fill(linkedHashSet, size);
        generator.fill(treeSet, size);

        print(arrayList);
        print(linkedList);
        print(hashSet);
        print(linkedHashSet);
        print(treeSet);
    }
}