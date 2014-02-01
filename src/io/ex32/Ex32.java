package io.ex32;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import net.mindview.util.TextFile;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;


public class Ex32 {
    public static void format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(64);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) {
        // File whose words are to be counted:
        String fileName = "WordCountXML.java";
        // Set of unique words in file:
        Set<String> uniqueWords = new TreeSet<String>(new TextFile(fileName,
                "\\W+"));
        // List of all words in file:
        ArrayList<String> allWords = new TextFile(fileName, "\\W+");
        Map<String, Integer> wordCount = new TreeMap<String, Integer>();
        // Count appearances of each unique word and add to map:
        for(String s : uniqueWords) {
            int count = 0;
            for(String t : allWords) {
                if(t.equals(s)) {
                    count++;
                }
            }
            wordCount.put(s, count);
        }
        Element root = new Element("words"); // XML root
        // Add map data to xml root:
        Iterator<Map.Entry<String, Integer>> it = wordCount.entrySet()
                .iterator();
        while(it.hasNext()) {
            Map.Entry<String, Integer> me = it.next();
            Element word = new Element("word");
            word.appendChild(me.getKey() + ": ");
            word.appendChild(Integer.toString(me.getValue()));
            root.appendChild(word);
        }
        Document doc = new Document(root);
        // Send output to console, and to new file WordCount.xml:
        try {
            format(System.out, doc);
            format(new BufferedOutputStream(new FileOutputStream(
                    "WordCount.xml")), doc);
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}