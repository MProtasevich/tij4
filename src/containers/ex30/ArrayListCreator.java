package containers.ex30;

import java.util.ArrayList;
import java.util.List;


public class ArrayListCreator implements ListCreator {
    @Override
    public List<Integer> createCollection(int size) {
        ArrayList<Integer> result = new ArrayList<Integer>(size);

        for(int i = 0; i < size; ++i) {
            result.add(rg.next());
        }

        return result;
    }
}