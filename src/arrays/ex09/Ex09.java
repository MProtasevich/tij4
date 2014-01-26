package arrays.ex09;


import java.util.*;


public class Ex09 {
    public static void main(String[] args) {
        // error
        // Peel<Banana>[] peels = new Peel<Banana>[10];
        List<Peel<Banana>> peels = new ArrayList<Peel<Banana>>();

        for(int i = 0; i < 10; i++) {
            peels.add(new Peel<Banana>(new Banana()));
        }

        System.out.println(peels);
        System.out.println("peels.get(0).getClass(): "
                + peels.get(0).getClass());
    }
}