package io.ex02;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class SortedDirList {
    String[] files;

    public SortedDirList(File file) {
        files = file.list();
        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
    }

    public String[] list() {
        return files;
    }

    public String[] list(String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        ArrayList<String> result = new ArrayList<String>(files.length);
        for(String file : files) {
            if(pattern.matcher(file).matches()) {
                result.add(file);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(String file : files) {
            sb.append(file + '\n');
        }

        return sb.toString();
    }
}