package containers.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import net.mindview.util.Countries;


public class Ex01 {
    public static void main(String[] args) {
        int num = 7;
        List<String> arrayList = new ArrayList<String>(Countries.capitals(num).keySet());
        System.out.println(arrayList);
        Collections.shuffle(arrayList);
        System.out.println(arrayList + "\n");

        List<String> linkedList = new LinkedList<String>(Countries.capitals(num).keySet());
        System.out.println(linkedList);
        Collections.shuffle(linkedList);
        System.out.println(linkedList);
    }
}