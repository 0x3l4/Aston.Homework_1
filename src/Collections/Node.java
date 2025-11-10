package Collections;

public class Node<K, V> implements INode<K, V>  {
    private final int _hash;
    private K _key;
    private V _value;
    private INode<K, V> _next;

    public Node(K key, V value) {
        _hash = key.hashCode();
        _key = key;
        _value = value;
    }

    @Override
    public boolean hasNext() {
        return _next != null;
    }

    @Override
    public INode<K, V> getNext() {
        return _next;
    }

    @Override
    public K getKey() {
        return _key;
    }

    @Override
    public V getValue() {
        return _value;
    }

    @Override
    public int getHash() {
        return _hash;
    }


    @Override
    public void setValue( V value) {
        _value = value;
    }

    @Override
    public void setNext(INode<K, V> node) {
        _next = node;
    }
}
