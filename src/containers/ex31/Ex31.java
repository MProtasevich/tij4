package containers.ex31;


import java.util.ArrayList;

import static net.mindview.util.Print.print;
import static containers.ex31.StringArrayTest.addTimeTest;
import static containers.ex31.StringArrayTest.getTimeTest;


public class Ex31 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        StringArray sh = new StringArray();

        print("Add times (nanoseconds):");
        print("Mean of 1000:");
        print("ArrayList add(): " + addTimeTest(list, 1000));
        print("StringArray add(): " + addTimeTest(sh, 1000));
        print("Mean of 10000:");
        print("ArrayList add(): " + addTimeTest(list, 10000));
        print("StringArray add(): " + addTimeTest(sh, 10000));
        print("\nGet times (nanoseconds):");

        print("Mean of 10000:");
        print("ArrayList get(): " + getTimeTest(list, 10000));
        print("StringArray get(): " + getTimeTest(sh, 10000));
    }
}