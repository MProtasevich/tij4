package containers.ex25;


import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
            LinkedList<MapEntry<K, V>> bucket = buckets[index];
            bucket.add(pair);
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        if(buckets[index].size() > 0) {
            for(MapEntry<K, V> entry = bucket.get(0); entry != null; entry = entry
                    .getNextEntry()) {
                if(entry.getKey().equals(key)) {
                    oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                }
            }
            bucket.add(pair);
            int i = bucket.indexOf(pair);
            if(i > 0) {
                bucket.get(i - 1).setNextEntry(pair);
            }
            return pair.getValue();
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
        for(LinkedList<MapEntry<K, V>> bucket : buckets) {
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