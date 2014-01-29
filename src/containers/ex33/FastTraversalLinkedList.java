package containers.ex33;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


class FastTraversalLinkedList<E> extends AbstractList<E> {
    private LinkedList<E> lList = new LinkedList<E>();
    private ArrayList<E> aList = new ArrayList<E>();

    private ArrayList<E> toArrayList(LinkedList<E> lList) {
        aList.clear();
        aList.addAll(lList);
        lList.clear();
        return aList;
    }

    private LinkedList<E> toLinkedList(ArrayList<E> aList) {
        lList.clear();
        lList.addAll(aList);
        aList.clear();
        return lList;
    }

    @Override
    public int size() {
        return Math.max(aList.size(), lList.size());
    }

    @Override
    public void clear() {
        if(aList.size() >= lList.size()) {
            aList.clear();
        }
        lList.clear();
    }

    @Override
    public boolean add(E e) {
        if(aList.size() < lList.size()) {
            return lList.add(e);
        } else {
            return toLinkedList(aList).add(e);
        }
    }

    @Override
    public void add(int i, E e) {
        if(aList.size() < lList.size()) {
            lList.add(i, e);
        } else {
            toLinkedList(aList).add(i, e);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(aList.size() < lList.size()) {
            return lList.addAll(c);
        } else {
            return toLinkedList(aList).addAll(c);
        }
    }

    public void addFirst(E e) {
        if(aList.size() < lList.size()) {
            lList.addFirst(e);
        } else {
            toLinkedList(aList).addFirst(e);
        }
    }

    public void addLast(E e) {
        if(aList.size() < lList.size()) {
            lList.addLast(e);
        } else {
            toLinkedList(aList).addLast(e);
        }
    }

    @Override
    public E set(int i, E e) {
        if(lList.size() < aList.size()) {
            return aList.set(i, e);
        } else {
            return toArrayList(lList).set(i, e);
        }
    }

    @Override
    public E remove(int i) {
        if(aList.size() < lList.size()) {
            return lList.remove(i);
        } else {
            return toLinkedList(aList).remove(i);
        }
    }

    public E removeFirst() {
        if(aList.size() < lList.size()) {
            return lList.removeFirst();
        } else {
            return toLinkedList(aList).removeFirst();
        }
    }

    public E removeLast() {
        if(aList.size() < lList.size()) {
            return lList.removeLast();
        } else {
            return toLinkedList(aList).removeLast();
        }
    }

    @Override
    public E get(int i) {
        if(lList.size() < aList.size()) {
            return aList.get(i);
        } else {
            return toArrayList(lList).get(i);
        }
    }

    @Override
    public Iterator<E> iterator() {
        if(lList.size() < aList.size()) {
            return aList.iterator();
        } else {
            return toArrayList(lList).iterator();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        if(aList.size() < lList.size()) {
            return lList.listIterator();
        } else {
            return toLinkedList(aList).listIterator();
        }
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        if(aList.size() < lList.size()) {
            return lList.listIterator(i);
        } else {
            return toLinkedList(aList).listIterator(i);
        }
    }

    @Override
    public String toString() {
        return aList.size() > lList.size() ? aList.toString()
                : lList.size() == 0 ? aList.toString() : lList.toString();
    }
}