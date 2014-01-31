package io.ex06;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.mindview.util.ProcessFiles;


public class Ex06 {
    public static void main(final String[] args) {
        if(args.length < 2) {
            System.out.println("Arguments missing");
            return;
        }
        ProcessFiles processFiles = new ProcessFiles(
                new ProcessFiles.Strategy() {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

                    @Override
                    public void process(File file) {
                        try {
                            if(file.lastModified() >= sdf.parse(args[1])
                                    .getTime()) {
                                System.out.println(file);
                            }
                        } catch(ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, "java");
        processFiles.start(args);
    }
}