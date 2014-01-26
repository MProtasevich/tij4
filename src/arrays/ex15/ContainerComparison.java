package arrays.ex15;


//: arrays/ContainerComparison.java
import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mindview.util.Generator;
import arrays.BerylliumSphere;


public class ContainerComparison {
    public static void main(String[] args) {
        Generator<BerylliumSphere> g = new SphereGenerator();
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for(int i = 0; i < 5; i++) {
            spheres[i] = g.next();
        }
        print(Arrays.toString(spheres));
        print(spheres[4]);
        List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
        for(int i = 0; i < 5; i++) {
            sphereList.add(g.next());
        }
        print(sphereList);
        print(sphereList.get(4));
    }
}