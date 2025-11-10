package Collections;

import java.util.Iterator;


public class HashSet<T> implements ISet<T>  {
    private static final Object PRESENT = new Object();

    private HashMap<T, Object> _map;

    public HashSet() {
        _map = new HashMap<>();
    }

    public int getBuckets() { return _map.getBuckets(); }

    @Override
    public boolean add(T elem) {
        return _map.put(elem, PRESENT) == null;
    }

    @Override
    public boolean remove(T elem) {
        return _map.remove(elem);
    }

    @Override
    public boolean contains(T elem) {
        return _map.contains(elem);
    }

    @Override
    public boolean isEmpty() {
        return _map.isEmpty();
    }

    @Override
    public int count() {
        return _map.count();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
