package inner_classes.ex04;


//: innerclasses/Sequence.java
// Holds a sequence of Objects.
interface Selector {
    boolean end();

    Object current();

    void next();
}


public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if(next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if(i < items.length) {
                i++;
            }
        }

        public Sequence sequence() {
            return Sequence.this;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }
    
    public static void main(String[] args) {
        Sequence sequence = new Sequence(5);
        for(int i = 0; i < 5; i++)
            sequence.add(Integer.toString(i));

        Selector selector = sequence.selector();

        System.out.println(((SequenceSelector)selector).sequence());
    }
}