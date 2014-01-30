package io.ex04;


import java.io.File;

import net.mindview.util.Directory;


public class Ex04 {
    public static void main(String[] args) {
        long sum = 0;
        if(args.length == 0) {
            for(File file : Directory.walk(".").files) {
                System.out.print(file + ": ");
                System.out.println(file.length());
                sum += file.length();
            }
        } else {
            for(String arg : args) {
                for(File file : Directory.walk(".", arg).files) {
                    System.out.print(file + ": ");
                    System.out.println(file.length());
                    sum += file.length();
                }
                System.out.println();
            }
        }
        System.out.println("Total size: " + sum);
    }
}