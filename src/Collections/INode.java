package Collections;

public interface INode<T> {
    boolean hasNext();
    INode<T> next();
    T getValue();
    void setValue(T value);
}
