package containers.ex16;


//: containers/SlowMap.java
// A Map implemented with ArrayLists.
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Countries;
import containers.MapEntry;


public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    private EntrySet entries = new EntrySet();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);// The old value or null
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override
    public V get(Object key) { // key is type Object, not K
        if(!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        /*
         * Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
         * Iterator<K> ki = keys.iterator(); Iterator<V> vi = values.iterator();
         * 
         * while(ki.hasNext()) { set.add(new MapEntry<K, V>(ki.next(),
         * vi.next())); }
         */
        return entries;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public int size() {
            return keys.size();
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public Map.Entry<K, V> next() {
                    int i = ++index;
                    return new MapEntry<K, V>(keys.get(i), values.get(i));
                }

                @Override
                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<String, String>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}