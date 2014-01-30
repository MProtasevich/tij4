package containers.ex42;

import net.mindview.util.RandomGenerator;


public class StringClass implements Comparable<StringClass> {
    private String str1, str2;
    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    private static RandomGenerator.String rg = new RandomGenerator.String();

    public StringClass() {
        this(rg.next(), rg.next());
    }

    public StringClass(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public int compareTo(StringClass sc) {
        return getStr1().compareToIgnoreCase(sc.getStr1());
    }

    @Override
    public String toString() {
        return "str1: " + str1 + "; str2: " + str2;
    }
}