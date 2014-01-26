package arrays.ex25;


import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;


class MyList<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1L;

    MyList(List<T> l) {
        this.addAll(l);
    }

    public MyList<T> getReversed() {
        ListIterator<T> lit = this.listIterator(this.size());
        List<T> reverseMyList = new ArrayList<T>();

        while(lit.hasPrevious()) {
            reverseMyList.add(lit.previous());
        }

        return new MyList<T>(reverseMyList);
    }
}


public class Ex25 {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4,
                5));
        print(aList);
        print(aList.get(4));
        aList.add(new Integer(6));
        aList.addAll(new ArrayList<Integer>(Arrays.asList(7, 8)));
        print(aList);
        print(aList.subList(2, 4));
        MyList<Integer> ml = new MyList<Integer>(aList);
        print((ml.getReversed()));
    }
}