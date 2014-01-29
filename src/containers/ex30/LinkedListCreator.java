package containers.ex30;


import java.util.LinkedList;
import java.util.List;


public class LinkedListCreator implements ListCreator {
    @Override
    public List<Integer> createCollection(int size) {
        LinkedList<Integer> result = new LinkedList<Integer>();

        for(int i = 0; i < size; ++i) {
            result.add(rg.next());
        }

        return result;
    }
}