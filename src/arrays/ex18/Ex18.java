package arrays.ex18;

import java.util.Arrays;

import net.mindview.util.Generated;
import arrays.BerylliumSphere;
import arrays.ex15.SphereGenerator;


public class Ex18 {
    public static void main(String[] args) {
        BerylliumSphere[] array1 = new BerylliumSphere[3];
        Generated.array(array1, new SphereGenerator());
        System.out.println(Arrays.toString(array1));

        BerylliumSphere[] array2 = new BerylliumSphere[4];
        System.out.println(Arrays.toString(array2));
        System.arraycopy(array1, 0, array2, 0, array1.length);
        System.out.println(Arrays.toString(array2));
    }
}