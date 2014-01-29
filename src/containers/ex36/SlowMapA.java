package containers.ex36;


import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import containers.MapEntry;


class SlowMapA<K, V> extends AbstractMap<K, V> {
    protected List<MapEntry<K, V>> entryList = new ArrayList<MapEntry<K, V>>();
    private EntrySet entries = new EntrySet();

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return entries;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public int size() {
            return entryList.size();
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < entryList.size() - 1;
                }

                @Override
                public Map.Entry<K, V> next() {
                    int i = ++index;
                    return entryList.get(i);
                }

                @Override
                public void remove() {
                    entryList.remove(index--);
                }
            };
        }
    }

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
        return oldValue;
    }

    @Override
    public V get(Object key) {
        Iterator<MapEntry<K, V>> it = entryList.iterator();

        while(it.hasNext()) {
            MapEntry<K, V> me = it.next();
            if(me.getKey().equals(key)) {
                return me.getValue();
            }
        }

        return null;
    }
}