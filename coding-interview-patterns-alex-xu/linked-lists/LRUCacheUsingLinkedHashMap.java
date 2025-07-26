import java.util.LinkedHashMap;

public class LRUCacheUsingLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCacheUsingLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public V getValue(K key) {
        return super.getOrDefault(key, null);
    }

    public void putValue(K key, V value) {
        super.put(key, value);
    }

}
