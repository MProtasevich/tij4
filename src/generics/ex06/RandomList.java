package generics.ex06;


//: generics/RandomList.java
import java.util.*;


public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<String>();

        String[] arrayStrings = ("The quick brown fox jumped over "
                + "the lazy brown dog").split(" ");
        for(String s : arrayStrings) {
            rs.add(s);
        }

        for(int i = 0; i < arrayStrings.length; i++) {
            System.out.print(rs.select() + " ");
        }
        
        RandomList<Integer> ri = new RandomList<Integer>();

        int[] arrayI = {0, 2, 1, 5, 11, 15, 3, 0, 1, 9};
        for(Integer i : arrayI) {
            ri.add(i);
        }

        for(int i = 0; i < arrayI.length; i++) {
            System.out.print(rs.select() + " ");
        }
        
        RandomList<Double> rd = new RandomList<Double>();

        double[] arrayD = {0.1, 3.2, 5.1, 4.5, 1.1, 15.34, 3.7, .0, 1.1, 8.9};
        for(Double i : arrayD) {
            rd.add(i);
        }

        for(int i = 0; i < arrayD.length; i++) {
            System.out.print(rs.select() + " ");
        }
    }
}