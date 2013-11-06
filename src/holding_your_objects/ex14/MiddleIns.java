package holding_your_objects.ex14;

import java.util.LinkedList;

public class MiddleIns {
    public static void insertInTheMiddle(LinkedList<Integer> lst, Integer i) {
        lst.listIterator(lst.size() / 2).add(i);
    }

    public static void main(String[] args) {
        final int nums = 5;
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i = 0; i < nums; i++) {
            insertInTheMiddle(list, i);
            System.out.println(list);
        }
    }
}