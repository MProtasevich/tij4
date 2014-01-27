package containers.ex03;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.Countries;


public class Ex03 {
    public static void main(String[] args) {
        int num = 7;
        Set<String> s1 = new HashSet<String>(Countries.names(num));
        System.out.println(s1);
        s1.addAll(Countries.names(num));
        System.out.println(s1);
        s1.addAll(Countries.names(num + 1));
        System.out.println(s1 + "\n");

        Set<String> s2 = new TreeSet<String>(Countries.names(num));
        System.out.println(s2);
        s2.addAll(Countries.names(num));
        System.out.println(s2);
        s2.addAll(Countries.names(num + 1));
        System.out.println(s2 + "\n");

        Set<String> s3 = new LinkedHashSet<String>(Countries.names(num));
        System.out.println(s3);
        s3.addAll(Countries.names(num));
        System.out.println(s3);
        s3.addAll(Countries.names(num + 1));
        System.out.println(s3 + "\n");
    }
}