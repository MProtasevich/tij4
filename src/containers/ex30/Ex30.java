package containers.ex30;

import static net.mindview.util.Print.print;
import static containers.ex30.SortTest.testList;


public class Ex30 {
    public static void main(String[] args) {
        print("Collections.sort() times (nanosecs):\n");

        print("Means of 10000 sorts:\n");

        print("Lists of 10 elements:");
        print("LinkedList: " + testList(10, 10000, new LinkedListCreator()));
        print("ArrayList:  " + testList(10, 10000, new ArrayListCreator()));

        print("\nLists of 100 elements:");
        print("LinkedList: " + testList(100, 10000, new LinkedListCreator()));
        print("ArrayList:  " + testList(100, 10000, new ArrayListCreator()));

        print("\nMeans of 1000 sorts:");

        print("Lists of 1000 elements:");
        print("LinkedList: " + testList(1000, 1000, new LinkedListCreator()));
        print("ArrayList:  " + testList(1000, 1000, new ArrayListCreator()));
    }
}