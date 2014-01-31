package io.ex12;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


public class Ex12 {
    public static LinkedList<String> read(String arg) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(arg));
        LinkedList<String> list = new LinkedList<String>();
        String line;
        while((line = bf.readLine()) != null) {
            list.addFirst(line);
        }
        bf.close();
        PrintWriter pw = new PrintWriter(new File(arg + ".rev"));
        for(String string : list) {
            pw.append(string + "\n");
        }
        pw.close();
        return list;
    }

    public static void main(String[] args) {
        try {
            read(args[0]);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}