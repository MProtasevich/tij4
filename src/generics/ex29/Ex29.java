package generics.ex29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import generics.ex02.Holder;


public class Ex29 {
    static <T> void f(Holder<List<?>> h) {
        h.getObject(0);
        h.setObject(Arrays.asList(0, 1, 2), 0);

        List<?> list = h.getObject(0);
        //  compilation error
        // list.add(new Object());
        // list.add(0, new Object());
        // list.addAll(Arrays.asList(1, 2, 3));
        // Iterator<Holder<?> it = list.iterator();
        // list.set(0, new Object());

        // runtime UnsupportedOperationException
        //list.add(null);
        //list.addAll(null);
        list.contains(null);
        list.contains(new Integer(0));
        list.equals(new ArrayList<Holder<?>>());
        list.equals(list);
        list.get(0);
        list.indexOf(null);
        list.indexOf(0);
        list.isEmpty();

        // runtime UnsupportedOperationException
        //list.remove(0);
        //list.remove(null);
        //list.removeAll(new ArrayList<Object>());
        //list.retainAll(new ArrayList<Object>());
        //list.add(null);
        //list.add(null);
        list.set(0, null);
        list.subList(0, 1);
        System.out.println(list.toArray());
    }

    static <T> void f(List<Holder<?>> list) {
        Holder<?> h = list.get(0);
        h.getObject(0);
        // compilation error
        // h.setObject(1, 0);

        //  compilation error
        list.add(new Holder<String>("1", "2", "3"));
        list.add(0, new Holder<String>("2", "5", "6"));
        // warning
        list.addAll(Arrays.asList(new Holder<String>("3", "4", "5")));
        @SuppressWarnings("unused")
        Iterator<Holder<?>> it = list.iterator();
        list.set(0, new Holder<String>("2", "3", "4"));

        list.add(new Holder<String>("2", "3", "4"));
        list.addAll(new ArrayList<Holder<?>>());
        list.contains(new Holder<String>("2", "3", "4"));
        list.contains(new Integer(0));
        list.equals(new ArrayList<Holder<?>>());
        list.equals(list);
        list.get(0);
        list.indexOf(null);
        list.indexOf(0);
        list.isEmpty();
        list.remove(0);
        list.remove(null);
        list.removeAll(new ArrayList<Holder<?>>());
        list.retainAll(new ArrayList<Holder<?>>());
        list.add(null);
        list.add(null);
        list.set(0, null);
        list.subList(0, 1);
        System.out.println(list.toArray());
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder<List<?>> holder = new Holder<List<?>>(new ArrayList<Object>(), new ArrayList<Object>(), new ArrayList<Object>());
        Ex29.f(holder);
        Ex29.f(new ArrayList<Holder<?>>(Arrays.asList(new Holder<String>("0", "1", "2"), new Holder<String>("1", "2", "3"))));
    }
}