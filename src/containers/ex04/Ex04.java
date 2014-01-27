package containers.ex04;


import java.util.Arrays;
import java.util.Collection;

import net.mindview.util.TextFile;


public class Ex04 {
    public static Collection<String> name(String fileName) {
        return Arrays.asList(TextFile.read(fileName).split(" "));
    }

    public static void main(String[] args) {
        System.out.println(name("src/containers/ex04/Ex04.java"));
    }
}