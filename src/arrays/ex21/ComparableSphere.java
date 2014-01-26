package arrays.ex21;


import arrays.BerylliumSphere;


public class ComparableSphere extends BerylliumSphere
                               implements Comparable<BerylliumSphere> {

    @Override
    public int compareTo(BerylliumSphere bs) {
        return (getId() > bs.getId()) ? -1 : ((getId() < bs.getId()) ? 1 : 0);
    }
}