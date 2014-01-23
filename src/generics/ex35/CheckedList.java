package generics.ex35;


//: generics/CheckedList.java
// Using Collection.checkedList().
import generics.coffee.*;

import java.util.*;


public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(@SuppressWarnings("rawtypes") List probablyDogs) {
        probablyDogs.add(new Breve());
    }

    public static void main(String[] args) {
        List<Breve> breveList = new ArrayList<Breve>();
        oldStyleMethod(breveList); // Quietly accepts a Cat
        List<Breve> breveList2 = Collections.checkedList(
                new ArrayList<Breve>(), Breve.class);
        try {
            oldStyleMethod(breveList2); // Throws an exception
        } catch(Exception e) {
            System.out.println(e);
        }
        // Derived types work fine:
        List<Coffee> pets = Collections.checkedList(new ArrayList<Coffee>(),
                Coffee.class);
        pets.add(new Breve());
        pets.add(new Americano());
    }
}