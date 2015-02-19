package com.y62wang.learn.basic;

/**
 * A class that represents a Binary Tree Node
 */
public class BinaryTreeNode<T> {
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private T value;

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(final BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(final BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }
}
