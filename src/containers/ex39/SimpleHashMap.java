package containers.ex39;


//: containers/SimpleHashMap.java
// A demonstration hashed Map.
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import containers.MapEntry;


public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // capacity field starts equal to SIZE
    private int capacity = SIZE;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        // Check and call rehash() if needed:
        if(this.size() > 0.75 * capacity) {
            rehash();
        }

        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;

        if(buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }

        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);
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

    @SuppressWarnings("unchecked")
    private void rehash() {
        capacity = Prime.firstPrimeAfter(capacity * 2);
        LinkedList<MapEntry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity];
        for(LinkedList<MapEntry<K, V>> bucket : oldBuckets) {
            if(bucket == null)
                continue;
            for(MapEntry<K, V> mpair : bucket)
                this.put(mpair.getKey(), mpair.getValue());
        }
    }

    public int capacity() {
        return capacity;
    }
}