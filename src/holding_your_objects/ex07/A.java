package holding_your_objects.ex07;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        List<A> list = new ArrayList<A>();

        for(int i = 0; i < 5; ++i) {
            list.add(new A());
        }

        System.out.println("List: " + list);

        List<A> subList = list.subList(1, 3);
        System.out.println("Sublist: " + subList);

        list.removeAll(subList);
        System.out.println("List \\ Sublist: " + list);
    }
}