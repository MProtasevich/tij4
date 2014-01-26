package arrays.ex02;

import arrays.BerylliumSphere;


public class Ex02 {
    public static BerylliumSphere[] createArray(int size) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[size];

        for(int i = 0; i < size; ++i) {
            berylliumSpheres[i] = new BerylliumSphere();
        }

        return berylliumSpheres;
    }

    public static void main(String[] args) {
        System.out.println(createArray(3));
    }
}