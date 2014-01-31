package io.ex10;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Ex10 {
    public static LinkedList<String> read(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(args[0]));
        LinkedList<String> list = new LinkedList<String>();
        String line;
        while((line = bf.readLine()) != null) {
            for(int i = 1; i < args.length; ++i) {
                if(line.contains(args[i])) {
                    list.addFirst(line);
                    break;
                }
            }
        }
        bf.close();
        return list;
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Arguments missing");
        }
        try {
            System.out.println(read(args));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}