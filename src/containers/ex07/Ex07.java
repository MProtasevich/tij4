package containers.ex07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

import net.mindview.util.Countries;


public class Ex07 {
    public static void main(String[] args) {
        int num = 7;
        Set<String> capitals = Countries.capitals(num).keySet();
        ArrayList<String> arrayList = new ArrayList<String>(capitals);
        LinkedList<String> linkedList = new LinkedList<String>(capitals);
        System.out.println(arrayList);
        System.out.println(linkedList);

        Iterator<String> aIt = arrayList.iterator();
        while(aIt.hasNext()) {
            System.out.println(aIt.next());
        }
        Iterator<String> lIt = linkedList.iterator();
        while(lIt.hasNext()) {
            System.out.println(lIt.next());
        }
        System.out.println(arrayList);
        System.out.println(linkedList);

        ListIterator<String> aLI = arrayList.listIterator();
        ListIterator<String> lLI = linkedList.listIterator();
        while(lLI.hasNext()) {
            aLI.add(lLI.next());
            aLI.next();
        }
        System.out.println(arrayList);
        System.out.println(linkedList);

        lLI = linkedList.listIterator();
        aLI = arrayList.listIterator(arrayList.size());
        while(lLI.hasNext()) {
            aLI.add(lLI.next());
            aLI.previous();
            aLI.previous();
        }
        System.out.println(arrayList);
        System.out.println(linkedList);
    }
}