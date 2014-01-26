package arrays.ex10;


import java.util.ArrayList;
import java.util.List;

import arrays.BerylliumSphere;


public class ArrayOfGenerics {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<List<String>> ls = new ArrayList<List<String>>();
        List<List<?>> la = new ArrayList<List<?>>();
        // error
        // ls = (List<List<String>>)la;
        ls.add(0, new ArrayList<String>());
        // Compile-time checking produces an error:
        // ! ls[1] = new ArrayList<Integer>();
        // The problem: List<String> is a subtype of Object
        // error
        // List<Object> objects = (List<Object>)ls;
        List<Object> objects = new ArrayList<Object>();
        // Compiles and runs without complaint:
        objects.add(1, new ArrayList<Integer>());
        // However, if your needs are straightforward it is
        // possible to create an array of generics, albeit
        // with an "unchecked" warning:
        List<List<BerylliumSphere>> spheres = new ArrayList<List<BerylliumSphere>>();

        for(int i = 0; i < 10; i++) {
            spheres.add(new ArrayList<BerylliumSphere>());
        }
    }
}