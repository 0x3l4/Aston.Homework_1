package Collections;

public class Node<T> implements INode<T>  {
    private T _value;
    private Node<T> _next;

    @Override
    public boolean hasNext() {
        return _next == null;
    }

    @Override
    public INode<T> next() {
        _value = _next._value;
        _next = _next._next;

        return this;
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public void setValue(T value) {
        _value = value;
    }
}
