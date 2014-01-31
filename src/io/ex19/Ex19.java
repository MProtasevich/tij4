package io.ex19;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.mindview.util.BinaryFile;


public class Ex19 {
    public static void main(String[] args) {
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        try {
            byte[] bytes = BinaryFile.read("src/io/ex19/Ex19.java");

            for(byte b : bytes) {
                Integer i = map.get(b);
                if(i == null) {
                    map.put(b, 1);
                } else {
                    map.put(b, i+1);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(map);
    }
}