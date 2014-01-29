package containers.ex37;


//: containers/SimpleHashMap.java
// A demonstration hashed Map.
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import containers.MapEntry;


public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    ArrayList<MapEntry<K, V>>[] buckets = new ArrayList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        if(buckets[index] == null) {
            buckets[index] = new ArrayList<MapEntry<K, V>>();
        }

        ArrayList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();

        while(it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                System.out.println("Collision: old - " + pair + 
                                    ", new - " + iPair);
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }

        if(!found) {
            buckets[index].add(pair);
        }

        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) {
            return null;
        }

        for(MapEntry<K, V> iPair : buckets[index]) {
            if(iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }

        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for(ArrayList<MapEntry<K, V>> bucket : buckets) {
            if(bucket == null) {
                continue;
            }

            for(MapEntry<K, V> mpair : bucket) {
                set.add(mpair);
            }
        }
        return set;
    }
}