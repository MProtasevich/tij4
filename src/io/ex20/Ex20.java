package io.ex20;


import static net.mindview.util.BinaryFile.read;
import static net.mindview.util.Print.print;

import java.io.File;
import java.io.IOException;

import net.mindview.util.Directory;


public class Ex20 {
    public static void main(String[] args) {
        try {
            for(File file : Directory.walk(".", ".*\\.class").files) {
                byte[] ba = read(file);
                for(int i = 0; i < 4; i++) {
                    print(Integer.toHexString(ba[i] & 0xff).toUpperCase());
                }
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}