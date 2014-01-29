package containers.ex36;


import java.util.Comparator;

import containers.MapEntry;


public class MapEntryKeyComp<K, V> implements Comparator<MapEntry<K, V>> {
    @Override
    public int compare(MapEntry<K, V> me1, MapEntry<K, V> me2) {
        int h1 = me1.getKey().hashCode(),
            h2 = me2.getKey().hashCode();
        return (h1 < h2) ? -1 : ((h1 > h2) ? 1 : 0);
    }
}