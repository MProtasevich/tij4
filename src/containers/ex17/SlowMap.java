package containers.ex17;


import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
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
    public V get(Object key) {
        if(!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
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

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if(o instanceof SlowMap) {
            if(entrySet().equals(((SlowMap<K, V>)o).entrySet())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override
    public void putAll(Map<? extends K,? extends V> m) {
        for(Map.Entry<? extends K,? extends V> me : m.entrySet()) {
            put(me.getKey(), me.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        V v = get(key);    
        int i = keys.indexOf(key);
        keys.remove(i);
        values.remove(i);
        return v;
    }
    
    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<String, String>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}