package containers.ex10;


public class Ex10 {
    public static void main(String[] args) {
        SortedSet<Integer> ss2 = new SortedSet<Integer>();
        ss2.add(6);
        ss2.add(8);
        ss2.add(2);
        ss2.add(4);
        ss2.add(2);
        ss2.add(8);
        System.out.println(ss2);
        SortedSet<String> ss3 = new SortedSet<String>();
        ss3.add("three");
        ss3.add("three");
        ss3.add("seven");
        ss3.add("hi");
        ss3.add("two");
        ss3.add("one");
        System.out.println(ss3);
    }
}