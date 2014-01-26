package arrays.ex15;


import arrays.BerylliumSphere;
import net.mindview.util.Generator;


public class SphereGenerator implements Generator<BerylliumSphere> {
    @Override
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}