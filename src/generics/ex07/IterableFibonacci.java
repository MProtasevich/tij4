package generics.ex07;


//: generics/IterableFibonacci.java
// Adapt the Fibonacci class to make it Iterable.
import java.util.*;


public class IterableFibonacci implements Iterable<Integer> {
    private int n;
    private Fibonacci fibonacci;

    public IterableFibonacci(int count) {
        fibonacci = new Fibonacci();
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibonacci.next();
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}