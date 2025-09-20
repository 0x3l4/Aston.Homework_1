package Collections;

import java.util.Iterator;

public class HashSet<T> implements ISet<T>  {
    private int _count;
    private int _buckets;
    private Node<T>[] _map;

    public HashSet() {
        _buckets = 4;
        _count = 0;
        _map = new Node[_buckets];
    }

    public HashSet(T[] values) {
        _buckets = values.length;
        _count = _buckets;
        _map = new Node[_buckets];
    }

    public int getCount() { return _count; }
    public int getBuckets() { return _buckets; }

    @Override
    public int hashCode(T value) {
        return value.hashCode() % _buckets;
    }

    @Override
    public boolean add(T elem) {
        if (_map.length < _count) {
            _buckets *= 2;

            Node<T>[] newMap = new Node[_buckets];

            for(var value : _map) {
                if (value != null) {
                    int indexBucket = value.hashCode() % _buckets;
                    newMap[indexBucket] = value;
                }
            }


        }
        return false;
    }

    @Override
    public boolean remove(T elem) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
