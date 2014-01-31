package io.ex14;

import io.BufferedInputFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;


public class Ex14 {
    static String inFile = "src/io/ex14/Ex14.java",
                   outFile = inFile + ".out",
                   outFile2 = inFile + ".2.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read(inFile)));
        // Buffered writer:
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                outFile)));
        int lineCount = 1;
        String s;
        long start = System.nanoTime();

        while((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }

        long duration = System.nanoTime() - start;
        out.close();
        System.out.println("Buffered write:   " + duration + " nanoseconds");
        BufferedReader in2 = new BufferedReader(new StringReader(
                BufferedInputFile.read(inFile)));
        // Unbuffered writer:
        PrintWriter out2 = new PrintWriter(new FileWriter(outFile2));
        int lineCount2 = 1;
        String s2;
        long start2 = System.nanoTime();

        while((s2 = in2.readLine()) != null) {
            out2.println(lineCount2++ + ": " + s2);
        }

        long duration2 = System.nanoTime() - start2;
        out2.close();
        System.out.println("Unbuffered write: " + duration2 + " nanoseconds");
    }
}