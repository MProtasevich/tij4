package containers.ex11;


import java.util.PriorityQueue;
import java.util.Random;


class A implements Comparable<A> {
    int i;

    A() {
        i = new Random().nextInt(100);
    }

    @Override
    public int compareTo(A a) {
        return (i < a.i) ? -1 : ((i > a.i) ? 1 : 0);
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}


public class Ex11 {
    public static void main(String[] args) {
        int num = 7;
        PriorityQueue<A> queue = new PriorityQueue<A>();

        for(int i = 0; i < num; ++i) {
            queue.add(new A());
        }

        System.out.println(queue);

        for(int i = 0; i < num; ++i) {
            System.out.println(queue.poll());
        }
    }
}