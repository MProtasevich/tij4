package containers.ex36;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import containers.MapEntry;


class SlowMapB<K, V> extends SlowMapA<K, V> {
    private List<MapEntry<Integer, V>> hashEntryList = new ArrayList<MapEntry<Integer, V>>();

    public List<MapEntry<Integer, V>> hashEntryList() {
        return hashEntryList;
    }

    private final MapEntryKeyComp<K, V> comp1 = new MapEntryKeyComp<K, V>();
    private final MapEntryKeyComp<Integer, V> comp2 = new MapEntryKeyComp<Integer, V>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        Iterator<MapEntry<K, V>> it = entryList.iterator();
        while(it.hasNext()) {
            MapEntry<K, V> me = it.next();
            if(me.getKey().equals(key)) {
                me.setValue(value);
            }
        }
        entryList.add(new MapEntry<K, V>(key, value));
        hashEntryList.add(new MapEntry<Integer, V>(key.hashCode(), value));

        Collections.sort(entryList, comp1);
        Collections.sort(hashEntryList, comp2);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        MapEntry<Integer, V> sub = new MapEntry<Integer, V>(key.hashCode(),
                null);
        int i = Collections.binarySearch(hashEntryList, sub, comp2);
        if(i >= 0)
            return hashEntryList.get(i).getValue();
        return null;
    }
}