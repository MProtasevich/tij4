package inner_classes.ex02;


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
        if(next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if(i < items.length)
                i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }
}