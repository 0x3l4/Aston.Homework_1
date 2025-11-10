package Collections;

import java.util.Collection;

public interface IList<T> extends ICollection<T> {
    T first();
    T last();
    IList<T> reverse();
    T elementAt(int index);
    void addFirst(T value);
    void addLast(T value);
    void addAll(T[] collection);
    void insert(int index, T value);
    void resize(int size);
}
