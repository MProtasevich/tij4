package interfaces.ex16;


import java.nio.*;
import java.util.*;


public class AdaptedRandomChars implements Readable {
    private static Random rand = new Random();
    private int count;

    public AdaptedRandomChars(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) {
        if(count-- == 0) {
            return -1;
        }

        String result = Character.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public char next() {
        return (char)rand.nextInt(128);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomChars(10));

        while(s.hasNext()) {
            System.out.println(s.next() + " ");
        }

        s.close();
    }
}