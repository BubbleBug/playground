package com.y62wang.learn.basic;

/**
 * A class that represents a singly linked list node
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(final T value) {
        setValue(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(final Node<T> next) {
        this.next = next;
    }
}
