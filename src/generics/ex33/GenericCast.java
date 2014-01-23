package generics.ex33;

import java.util.ArrayList;
import java.util.List;


//: generics/GenericCast.java
class FixedSizeStack<T> {
    private int index = 0;
    private List<T> storage;

    public FixedSizeStack(int size) {
        storage = new ArrayList<T>(size);
    }

    public void push(T item) {
        if(storage.size() > index) {
            storage.set(index++, item);
        } else {
            System.out.println("Stack is has no free cells");
        }
    }

    public T pop() {
        if(index == 0) {
            return storage.remove(index--);
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
}


public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);

        for(String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }

        for(int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
        // Exception throwing verified. Bounds-checking code still required.
        strings.pop();
        
    }
} /*
   * Output: J I H G F E D C B A
   */// :~