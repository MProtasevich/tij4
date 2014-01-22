package generics.ex13;


//: generics/Generators.java
// A utility to use with Generators.
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import net.mindview.util.Generator;


public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen,
            int n) {
        for(int i = 0; i < n; i++) {
            coll.add(gen.next());
        }

        return coll;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        for(int i = 0; i < n; i++) {
            list.add(gen.next());
        }

        return list;
    }

    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {
        for(int i = 0; i < n; i++) {
            queue.add(gen.next());
        }

        return queue;
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
        for(int i = 0; i < n; i++) {
            set.add(gen.next());
        }

        return set;
    }

    // return type LinkedList:
    public static <T> LinkedList<T>
        fill(LinkedList<T> linkedList, Generator<T> gen, int n) {

        for(int i = 0; i < n; i++) {
            linkedList.add(gen.next());
        }

        return linkedList;
    }
}