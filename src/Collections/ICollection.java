package Collections;

public interface ICollection<T> extends Iterable<T> {
    boolean add(T elem);
    boolean remove(T elem);
}
