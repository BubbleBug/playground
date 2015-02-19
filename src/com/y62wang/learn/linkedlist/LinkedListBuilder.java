package com.y62wang.learn.linkedlist;

import com.y62wang.learn.basic.Node;

/**
 * A utility class that creates a linked-list of type T
 *
 * @param <T> the type of the values stored in the linked-list
 */
public class LinkedListBuilder<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    public void addNode(final T value) {
        final Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void addNodes(final T... values) {
        for (final T value : values) {
            addNode(value);
        }
    }

    public Node<T> build() {
        return head;
    }
}
