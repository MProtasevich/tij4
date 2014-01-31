package io.ex13;


//: io/BasicFileOutput.java
import io.BufferedInputFile;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;


public class BasicFileOutput {
    static String inFile = "src/io/ex13/BasicFileOutput.java";

    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(new FileReader(inFile));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                inFile + ".out")));
        String s;

        while((s = in.readLine()) != null) {
            out.println(in.getLineNumber() + ": " + s);
        }

        in.close();
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(inFile + ".out"));
    }
}