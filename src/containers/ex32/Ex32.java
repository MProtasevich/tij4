package containers.ex32;


import static net.mindview.util.Print.print;
import static containers.ex32.IntegerArrayTest.addTimeTest;
import static containers.ex32.IntegerArrayTest.getTimeTest;
import static containers.ex32.IntegerArrayTest.incrementInArray;
import static containers.ex32.IntegerArrayTest.incrementInList;

import java.util.ArrayList;


public class Ex32 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        IntegerArray ih = new IntegerArray();
        print("Add times (nanoseconds):");
        print("Mean of 1000:");
        print("ArrayList add(): " + addTimeTest(list, 1000));
        print("IntsHolder add(): " + addTimeTest(ih, 1000));
        print("Mean of 10000:");
        print("ArrayList add(): " + addTimeTest(list, 10000));
        print("IntsHolder add(): " + addTimeTest(ih, 10000));
        print();
        print("Get times (nanoseconds):");
        print("Mean of 10000:");
        print("ArrayList get(): " + getTimeTest(list, 10000));
        print("IntsHolder get(): " + getTimeTest(ih, 10000));
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        for(int i = 0; i < 1000; ++i) {
            list3.add(1);
        }
        IntegerArray ih3 = new IntegerArray();
        for(int i = 0; i < 1000; ++i) {
            ih3.add(1);
        }
        IntegerArray ih4 = new IntegerArray();
        for(int i = 0; i < 1000; ++i) {
            ih4.add(1);
        }
        print("Increment times (1000 elements):");
        print("ArrayList: " + incrementInList(list3, 1000));
        print("IntsHolder: " + incrementInArray(ih3, 1000));
    }
}