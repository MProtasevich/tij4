package error_handling.ex12;


//: innerclasses/Sequence.java
// Holds a sequence of Objects.
interface Selector {
    boolean end();

    Object current();

    void next();
}


public class Ex12 {
    private Object[] items;
    private int next = 0;

    public Ex12(int size) {
        items = new Object[size];
    }

    public void add(Object x) throws ArrayIndexOutOfBoundsException {
        items[next++] = x;
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
            if(i < items.length)
                i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Ex12 sequence = new Ex12(5);
        for(int i = 0; i < 6; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}