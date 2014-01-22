package generics.ex07;


//: generics/Fibonacci.java
// Generate a Fibonacci sequence.
import net.mindview.util.*;


public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    private int last, prelast;

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if(n < 2) {
            last = prelast = 1;
            return 1;
        }
        
        last += prelast;
        prelast = last - prelast;

        return last;
    }

    /*public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for(int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }
    }*/
}