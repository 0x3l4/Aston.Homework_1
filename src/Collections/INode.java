package Collections;

public interface INode<K, V> {
    boolean hasNext();
    INode<K, V> getNext();
    K getKey();
    V getValue();
    int getHash();
    void setValue(V value);
    void setNext(INode<K, V> node);
}
