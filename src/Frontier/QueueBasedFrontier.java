package Frontier;

import java.util.LinkedList;

public class QueueBasedFrontier<T> implements Frontier<T> {
    LinkedList<T> queue = new LinkedList<>();

    @Override
    public void add(T item) {
        queue.add(item);
    }

    @Override
    public T remove() {
        return queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
