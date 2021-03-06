//: net/mindview/util/TextFile.java
package io.ex18;


import java.io.*;
import java.util.*;


public class TextFile extends ArrayList<String> {
    private static final long serialVersionUID = -7862048067122202787L;

    // Read a file as a single string:
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()));
        try {
            String s;
            while((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    // Write a single file in one method call:
    public static void write(String fileName, String text) throws IOException {
        PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
        try {
            out.print(text);
        } finally {
            out.close();
        }
    }

    // Read a file, split by any regular expression:
    public TextFile(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if(get(0).equals("")) {
            remove(0);
        }
    }

    // Normally read by lines:
    public TextFile(String fileName) throws IOException {
        this(fileName, "\n");
    }

    public void write(String fileName) throws IOException {
        PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
        try {
            for(String item : this) {
                out.println(item);
            }
        } finally {
            out.close();
        }
    }

    // Simple test:
    public static void main(String[] args) {
        try {
            String file = read("TextFile.java");
            write("test.txt", file);
            TextFile text = new TextFile("test.txt");
            text.write("test2.txt");
            // Break into unique sorted list of words:
            TreeSet<String> words = new TreeSet<String>(new TextFile(
                    "TextFile.java", "\\W+"));
            // Display the capitalized words:
            System.out.println(words.headSet("a"));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}