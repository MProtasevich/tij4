package io.ex01;


import java.io.File;
import java.io.FilenameFilter;

import net.mindview.util.TextFile;


public class DirFilter implements FilenameFilter {
    String[] args;

    public DirFilter(String[] args) {
        this.args = args;
    }

    @Override
    public boolean accept(File dir, String name) {
        for(String arg : args) {
            if(TextFile.read("src/io/ex01/" + name).indexOf(arg) >= 0) {
                return true;
            }
        }
        return false;
    }
}