package io.ex01;


//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}
import java.io.File;
import java.util.Arrays;


public class DirList {
    public static void main(String[] args) {
        File path = new File("src/io/ex01/");
        String[] list;

        if(args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args));
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}