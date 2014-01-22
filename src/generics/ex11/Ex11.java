package generics.ex11;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.mindview.util.New;
import reusing_classes.ex08.*;


public class Ex11 {
    public static void main(String[] args) {
        A a = new A(0);
        B b = new B(1);

        List<A> list = New.list();
        list.add(a);
        list.add(b);
        System.out.println(list);

        LinkedList<A> linkedList = New.lList();
        linkedList.add(a);
        linkedList.add(b);
        System.out.println(linkedList);

        Set<A> set = New.set();
        set.add(a);
        set.add(b);
        System.out.println(set);

        Map<A, B> map = New.map();
        map.put(a, b);
        System.out.println(map);
    }
}