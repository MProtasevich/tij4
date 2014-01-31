package io.ex07;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Ex07 {
    public static LinkedList<String> read(String arg) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(arg));
        LinkedList<String> list = new LinkedList<String>();
        String line;

        while((line = bf.readLine()) != null) {
            list.addFirst(line);
        }

        bf.close();
        return list;
    }

    public static void main(String[] args) {
        try {
            System.out.println(read("src/io/ex07/Ex07.java"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}