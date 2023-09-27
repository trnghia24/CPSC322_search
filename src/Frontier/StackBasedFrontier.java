package Frontier;

import Frontier.Frontier;

import java.util.Stack;

public class StackBasedFrontier<T> implements Frontier<T> {
    private Stack<T> stack = new Stack<>();
    @Override
    public void add(T item) {
        stack.push(item);
    }

    @Override
    public T remove() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
