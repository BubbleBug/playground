package com.y62wang.learn.linkedlist;

import com.y62wang.learn.basic.Node;
import com.y62wang.learn.framework.IAlgorithm;

/**
 * Given a linked list, remove and return the head of the modified list
 */
public class RemoveMiddleNodeAlgorithm<T> implements IAlgorithm {

    private final Node<T> head;

    public RemoveMiddleNodeAlgorithm(final Node<T> head) {
        this.head = head;
    }

    @Override
    public Node<T> run() {
        return removeMiddleNode(head);
    }

    private Node<T> removeMiddleNode(final Node<T> head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        Node<T> slowNode = head;
        Node<T> fastNode = head;
        Node<T> slowNodePrev = head;
        boolean moveSlowerNode = false;

        while (fastNode != null) {
            fastNode = fastNode.getNext();
            if (!moveSlowerNode) {
                moveSlowerNode = true;
            } else {
                slowNodePrev = slowNode;
                slowNode = slowNode.getNext();
                moveSlowerNode = false;
            }
        }

        slowNodePrev.setNext(slowNode.getNext());
        return head;
    }
}
