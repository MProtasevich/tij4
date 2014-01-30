package containers.ex41;


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
        return getStr1().compareTo(sc.getStr1());
    }

    @Override
    public String toString() {
        return "str1: " + str1 + "; str2: " + str2;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StringClass) {
            StringClass sc = (StringClass)obj;
            return getStr1().equals(sc.getStr1()) &&
                    getStr2().equals(sc.getStr2());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + getStr1().hashCode();
        result = 37 * result + getStr2().hashCode();
        return result;
    }
}