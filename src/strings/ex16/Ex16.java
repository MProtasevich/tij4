package strings.ex16;


import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;


public class Ex16 {
    public static boolean findDir(String dir, Pattern p) {
        Matcher e = Pattern.compile("^\\.{1}$").matcher(dir);
        if(e.find()) {
            File[] files = new File(dir).listFiles();
            System.out.println("root dir of files: " + Arrays.asList(files));

            for(File f : files) {
                if(f.getName().matches("\\w+\\.{1}\\w+")) {
                    System.out.println(f.getName() + ":");
                    int index = 0;
                    Matcher m = p.matcher("");
                    for(String line : new TextFile(f.getName())) {
                        m.reset(line);
                        while(m.find()) {
                            System.out.println(index++ + ": " + m.group() +
                                    ": " + m.start());
                        }
                                    
                    }
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }

    public static boolean findFile(String file, Pattern p) {
        Matcher fileMatcher = Pattern.compile("\\w+\\.{1}\\w+").matcher(file);
        if(fileMatcher.find()) {
            System.out.println("File: " + file);

            int index = 0;
            Matcher m = p.matcher("");
            for(String line : new TextFile(file)) {
                m.reset(line);
                while(m.find()) {
                    System.out.println(index++ + ": " + m.group() + ": " +
                            m.start());
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.out.println("Usage: java JGrep (file or directory) regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);

        if(!(findDir(args[0], p) || findFile(args[0], p))) {
            if(new File(args[0]).listFiles() == null) {
                System.out.println("no such directory: " + args[0]);
                System.exit(0);
            }
            File[] files = new File(args[0]).listFiles();
            System.out.println(args[0] + ": subdir of files: "
                    + Arrays.asList(files));

            for(File f : files) {
                int index = 0;
                Matcher m = p.matcher("");
                for(String line : new TextFile(args[0] + "\\" + f.getName())) {
                    m.reset(line);
                    while(m.find()) {
                        System.out.println(index++ + ": " + m.group() + ": " +
                                m.start());
                    }
                }
                System.out.println();
            }
        }
    }
}