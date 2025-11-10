package Collections;

import java.util.Iterator;

public class ArrayList<T> implements IList<T> {
    protected T[] _list;
    protected int _capacity;
    protected int _count;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        _capacity = capacity;
        _count = 0;
        _list = (T[]) new Object[_capacity];
    }

    public ArrayList(T[] collection) {
        _capacity = collection.length;
        _count = _capacity;
        _list = collection;
    }

    @Override
    public T first() {
        if (_count <= 0) {
            throw new IndexOutOfBoundsException();
        }

        return _list[0];
    }

    @Override
    public T last() {
        if (_count <= 0) {
            throw new IndexOutOfBoundsException();
        }

        return _list[_count - 1];
    }

    @Override
    public IList<T> reverse() {
        T[] newList = (T[]) new Object[_capacity];

        if (_count <= 0)
            return new ArrayList<>(newList);

        for (int i = 0; i < _count; i++) {

            newList[i] = _list[_count - i - 1];
        }

        return null;
    }

    @Override
    public T elementAt(int index) {
        if (index >= _count)
            throw new IndexOutOfBoundsException();

        return _list[index];
    }

    @Override
    public void addFirst(T value) {
        insert(0, value);
    }

    @Override
    public void addLast(T value) {
        if (_count >= _capacity)
            resize(_capacity * 2);

        _list[_count++] = value;
    }

    @Override
    public void addAll(T[] collection) {
        if (_count + collection.length > _capacity) {
            _capacity = _count + collection.length;

            resize(_capacity);
        }

        for (int i = 0; i < collection.length; i++) {
            _list[i + _count] = collection[i];
        }

        _count += collection.length;
    }

    @Override
    public void insert(int index, T value) {
        if (index >= _count)
            throw new IndexOutOfBoundsException();

        if (_capacity <= _count)
            resize(_capacity * 2);

        T old = _list[index];
        _list[index] = value;


        for (int i = index + 1; i < _count; i++) {
            _list[i] = old;
            old = _list[i + 1];
        }

        _count++;
    }

    @Override
    public void resize(int size) {
        if (_count > size) {
            throw new IllegalArgumentException();
        }

        T[] newList = (T[]) new Object[size];


        for (int i = 0; i < _count; i++) {
            newList[i] = _list[i];
        }

        _list = newList;
    }

    @Override
    public boolean add(T elem) {
        try {
            addLast(elem);

            return true;
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public boolean remove(T elem) {
        for (int i = 0; i < _list.length; i++) {
            if (elem == _list[i]) {
                for (int j = i; j < _list.length; j++) {
                    if (_capacity > i + 1)
                        _list[i] = _list[i + 1];
                }

                _count--;

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(T elem) {
        for (int i = 0; i < _count; i++) {
            if (_list[i].equals(elem)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return _count <= 0;
    }

    @Override
    public int count() {
        return _count;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
