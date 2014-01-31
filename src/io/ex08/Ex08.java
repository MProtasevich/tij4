package io.ex08;

import io.ex07.Ex07;

import java.io.IOException;


public class Ex08 {
    public static void main(String[] args) {
        if(args.length > 0) {
            try {
                System.out.println(Ex07.read(args[0]));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}