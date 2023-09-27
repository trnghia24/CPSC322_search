package Frontier;

public interface Frontier<T> {
    void add(T item);
    T remove();
    boolean isEmpty();
}
