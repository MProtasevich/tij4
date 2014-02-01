package io.ex27;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Ex27 {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        B b = new B('B');
        A a = new A('a', b);
        System.out.println("a:  " + a);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                "STest.out"));
        out.writeObject(a);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                "STest.out"));
        A a2 = (A)in.readObject();
        System.out.println("a2: " + a2);
        in.close();
    }
}