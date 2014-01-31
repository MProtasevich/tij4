package io.ex17;

import static net.mindview.util.TextFile.read;

import java.util.HashMap;
import java.util.Map;


public class Ex17 {
    public static void main(String[] args) {
        char[] textFile = read("src/io/ex17/Ex17.java").toCharArray();

        Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
        for(char c : textFile) {
            Integer i = dictionary.get(c);
            if(i == null) {
                dictionary.put(c, 1);
            } else {
                dictionary.put(c, i+1);
            }
        }

        System.out.println(dictionary);
    }
}