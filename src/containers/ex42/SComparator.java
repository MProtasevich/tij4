package containers.ex42;


import java.util.Comparator;


public class SComparator implements Comparator<StringClass> {
    @Override
    public int compare(StringClass o1, StringClass o2) {
        return o1.getStr2().compareToIgnoreCase(o2.getStr2());
    }
}