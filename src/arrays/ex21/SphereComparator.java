package arrays.ex21;


import java.util.Comparator;

import arrays.BerylliumSphere;


public class SphereComparator implements Comparator<BerylliumSphere> {
    @Override
    public int compare(BerylliumSphere bs1, BerylliumSphere bs2) {
        return (bs1.getId() > bs2.getId()) ? 1 :
                    ((bs1.getId() < bs2.getId()) ? -1 : 0);
    }
}