package arrays.ex01;


import arrays.BerylliumSphere;


public class Ex01 {
    public static void f(BerylliumSphere[] array) {
        System.out.println(array);
    }

    public static void main(String[] args) {
        f(new BerylliumSphere[2]);

        f(new BerylliumSphere[] {
                new BerylliumSphere(),
                new BerylliumSphere() });

        // doesn't work
        //f({ new BerylliumSphere(), new BerylliumSphere() });

        BerylliumSphere[] a = {
                new BerylliumSphere(),
                new BerylliumSphere() };
        f(a);
    }
}