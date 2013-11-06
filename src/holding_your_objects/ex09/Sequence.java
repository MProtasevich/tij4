package holding_your_objects.ex09;

import java.util.*;


//: innerclasses/Sequence.java
// Holds a sequence of Objects.
interface Selector {
    boolean end();

    Object current();

    void next();
}


public class Sequence {
    private List<Object> items;

    public Sequence(int size) {
        items = new ArrayList<Object>(size);
    }

    public void add(Object x) {
        items.add(x);
    }

    public Iterator<Object> iterator() {
        return items.iterator();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Iterator<Object> iterator = sequence.iterator();

        while(!iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}