package Collections;

import java.util.Iterator;

public class HashSet<T> implements ICollection<T>  {
    private int _count;
    private int _capacity;
    private int _buckets;
    private Node<T>[] _values;

    public HashSet() {
        _capacity = 4;
        _count = 0;
//        _values = new Node[_count];
        _values = (Node<T>[]) new Object[_capacity];
    }

    public int getCount() {
        return _count;
    }

    public int getCapacity() {
        return _capacity;
    }

    @Override
    public boolean add(T elem) {
        if (_values.length < _count) {
            _count *= 2;
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
