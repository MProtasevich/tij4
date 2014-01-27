package containers.ex08;


public class Ex08 {
    public static void main(String[] args) {
        SList<Integer> sl = new SList<Integer>();
        System.out.println(sl);
        SListIterator<Integer> slIter = sl.iterator();
        System.out.println("inserting");
        slIter.insert(1);
        System.out.println(sl);
        System.out.println("inserting");
        slIter.insert(2);
        System.out.println(sl);
        System.out.println("inserting");
        slIter.insert(3);
        System.out.println(sl);

        SListIterator<Integer> slIter2 = sl.iterator();
        System.out.println("removing");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("inserting");
        slIter2.insert(4);
        System.out.println(sl);
        System.out.println("removing");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing");
        slIter2.remove();
        System.out.println(sl);
        SListIterator<Integer> slIter3 = sl.iterator();
        slIter3.remove();
        System.out.println(sl);
    }
}