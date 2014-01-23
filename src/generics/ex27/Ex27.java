package generics.ex27;


import java.util.ArrayList;
import java.util.List;


public class Ex27 {
    public static void main(String[] args) {
        // compile error: incompatible types:
        // List<Number> lnum = new ArrayList<Integer>();
        List<? extends Number> list = new ArrayList<Integer>();
        // compile error: can't add Integer:
        // nlist.add(new Integer(0));
        list.add(null); // can add null
        Number x = list.get(0); // can get Number (null)

        System.out.println(list);
        System.out.println(x);
    }
}