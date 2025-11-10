package Collections;

public interface IMap<K, V> {
    V put(K key, V value);
    V get(K key);
    int count();
    int getBuckets();
    boolean remove(K key);
    boolean isEmpty();
    boolean contains(K key);
}
