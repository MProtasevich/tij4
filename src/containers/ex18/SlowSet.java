package containers.ex18;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class SlowSet<E> extends AbstractSet<E> {
    private List<E> values = new ArrayList<E>();

    @Override
    public boolean add(E e) {
        if(!values.contains(e)) {
            return values.add(e);
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean ok = false;
        for(E e : c) {
            if(!values.contains(e)) {
                values.add(e);
                ok = true;
            }
        }
        return ok;
    }

    @Override
    public void clear() {
        values.clear();
    }

    @Override
    public boolean contains(Object o) {
        return values.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return values.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof SlowSet) {
            
        }
        return super.equals(o);
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return values.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return values.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return values.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return values.retainAll(c);
    }

    @Override
    public int size() {
        return values.size();
    };

    @Override
    public Object[] toArray() {
        return values.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return values.toArray(a);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}