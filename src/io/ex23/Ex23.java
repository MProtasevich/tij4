package io.ex23;


import java.nio.CharBuffer;


public class Ex23 {
    public static boolean isPrintable(char c) {
        return ((c >= '!') && (c <= '~'));
    }

    public static void printCharBuffer(CharBuffer cb) {
        cb.clear();
        while(cb.hasRemaining()) {
            char c = cb.get();
            if(!isPrintable(c)) {
                break;
            }
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        char[] ca = { 'w', 'x', 'y', 'z' };
        CharBuffer cb = CharBuffer.wrap(ca);
        System.out.println("CharBuffer by wrapping char[]: ");
        printCharBuffer(cb);
        System.out.println();
        CharBuffer cb2 = CharBuffer.allocate(6);

        char[] ca2 = { 's', 't', 'u', 'v', 'w' };
        cb2.put(ca2);
        System.out.println("CharBuffer by allocation: ");
        printCharBuffer(cb2);
        System.out.println();

        char[] ca3 = { 'b', 'y', (char)0x01, (char)0x07, (char)0x7F, 'e' };
        CharBuffer cb3 = CharBuffer.wrap(ca3);
        System.out.println("CharBuffer including some unprintables: ");
        printCharBuffer(cb3);
    }
}