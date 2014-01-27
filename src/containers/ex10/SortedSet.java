package containers.ex10;


import java.util.LinkedList;
import java.util.ListIterator;


public class SortedSet<T> extends LinkedList<T> {
    private static final long serialVersionUID = 1L;

    private int compare(T t1, T t2) {
        int h1 = t1.hashCode(), h2 = t2.hashCode();
        return (h1 < h2) ? -1 : ((h1 == h2) ? 0 : 1);
    }

    @Override
    public boolean add(T t) {
        if(!this.contains(t)) {
            ListIterator<T> it = this.listIterator();

            while(it.hasNext()) {
                if(compare(it.next(), t) > 0) {
                    it.previous();
                    break;
                }
            }
            it.add(t);
        }
        return false;
    }

    @Override
    public void add(int index, T element) {
        this.add(element);
    }
}