package com.petrjanik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * @author Petr Janik 485122
 * @since 27/06/2019
 */
public class Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }
}

class StackDemo {
    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        numberStack.push(42);
        Iterable<Integer> integers = Arrays.asList(1, 2, 3);
        numberStack.pushAll(integers);
        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);
        System.out.println(objects);
    }
}
