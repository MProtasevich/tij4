package holding_your_objects.ex12;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Reverse {
    static Integer[] range(final int left, final int right, final int step) {
        int numOfElements = (right - left) / step;
        int currentVal = left;
        Integer[] result = new Integer[numOfElements];

        for(int i = 0; i < numOfElements; ++i) {
            result[i] = currentVal;
            currentVal += step;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> lst1 = new LinkedList<Integer>(Arrays.asList(range(0, 5, 1)));
        List<Integer> lst2 = new LinkedList<Integer>(Arrays.asList(range(5, 10, 1)));
        
        System.out.println(lst1);
        System.out.println(lst2);

        ListIterator<Integer> li1 = lst1.listIterator(lst1.size());
        ListIterator<Integer> li2 = lst2.listIterator();

        while(li1.hasPrevious() && li2.hasNext()) {
            li2.next();
            li2.set(li1.previous());
        }

        System.out.println("\n" + lst1);
        System.out.println(lst2);
    }
}