package io.ex02;


import java.io.File;
import java.util.Arrays;


public class Ex02 {
    public static void main(String[] args) {
        SortedDirList dirList = new SortedDirList(new File("."));

        System.out.println(Arrays.toString(dirList.list()));

        System.out.println(Arrays.toString(dirList.list("s[\\w]*")));
    }
}