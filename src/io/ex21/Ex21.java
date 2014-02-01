package io.ex21;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex21 {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("src/io/ex21/Ex21.java")));
            System.setIn(bis);
        } catch(IOException ioe) {
            System.out.println("Can't create stream for file.");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while((s = in.readLine()) != null) {
                System.out.println(s.toUpperCase());
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}