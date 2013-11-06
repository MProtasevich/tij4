package holding_your_objects.ex30;


import java.util.Collection;
import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;


public class CollectionSequence implements Collection<Pet> {
    private Pet[] pets = Pets.createArray(8);

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public void clear() {
        if(this.size() != 0) {
            for(Pet p : pets) {
                p.toString();
                p = null;
            }
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Pet> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0) ? true : false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Pet p) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return pets;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}