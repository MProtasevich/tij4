package io.ex03;


import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Ex03 {
    public static void main(final String[] args) {
        File path = new File(".");
        File[] files;
        if(args.length == 0) {
            files = path.listFiles();
        } else {
            files = path.listFiles(new FileFilter() {
                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File file) {
                    return pattern.matcher(file.getPath()).matches();
                }
            });
        }
        Arrays.sort(files);
        long sum = 0;
        for(File f : files) {
            System.out.print(f + ": ");
            System.out.println(f.length());
            sum += f.length();
        }
        System.out.println("Total size: " + sum);
    }
}