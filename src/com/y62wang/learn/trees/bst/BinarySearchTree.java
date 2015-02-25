package com.y62wang.learn.trees.bst;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

/**
 * A Binary Search Tree
 *
 * @param <K> key type
 * @param <T> value type
 */
public class BinarySearchTree<K extends Comparable<K>, T> {

    private Node<K,T> root;

    public BinarySearchTree() {
    }

    public void insert(final K key, final T val) {
        final Node<K,T> node = new Node<K, T>();
        node.key = key;
        node.value = val;

        if(root == null) {
            root = node;
            return;
        }

        Node currentNode = root;
        while(currentNode != null) {
            final int comparisonResult = currentNode.key.compareTo(key);
            if(comparisonResult < 0) {
                if(currentNode.right == null) {
                    currentNode.right = node;
                    node.parent = currentNode;
                    return;
                }
                currentNode = currentNode.right;
            } else {
                if(currentNode.left == null) {
                    currentNode.left = node;
                    node.parent = currentNode;
                    return;
                }
                currentNode = currentNode.left;
            }
        }
    }

    public void delete(final K key) {
            final Node<K,T> node = binarySearch(key);
        final Node<K,T> replacement;
        Node<K,T> newChild;

        if(node.left == null | node.right == null) {
                replacement = node;
            } else {
                replacement = getSuccessor(node);
            }

            if(replacement.left != null) {
                newChild = replacement.left;
            } else {
                newChild = replacement.right;
            }

            if(newChild != null) {
                newChild.parent = replacement.parent;
            }

            if(replacement.parent == null) {
                root = newChild;
            } else if(replacement.parent.left == replacement) {
                replacement.parent.left = newChild;
            } else {
                replacement.parent.right = newChild;
            }

            if(replacement != node) {
                node.key = replacement.key;
                node.value = replacement.value;
            }
    }

    @VisibleForTesting
    public Node<K,T> getPredecessor(final Node<K,T> node) {
        if(node.left!=null) {
            return getMaximum(node.left);
        }
        Node<K,T> currentNode = node, parent = currentNode.parent;
        while(parent != null && currentNode == parent.left) {
            currentNode = currentNode.parent;
            parent = currentNode.parent;
        }
        return parent;
    }

    @VisibleForTesting
    public Node<K,T> getSuccessor(final Node<K,T> node) {
        if(node.right != null) {
            return getMinimum(node.right);
        }
        Node<K,T> currentNode = node, parent = currentNode.parent;
        while(parent != null && currentNode == parent.right) {
            currentNode = currentNode.parent;
            parent = currentNode.parent;
        }
        return parent;
    }

    public T search(final K key) {
        final Node<K, T> result = binarySearch(key);
        return result == null ? null : result.value;
    }

    public void clear() {
        root = null;
    }

    @VisibleForTesting
    public Node<K,T> getMaximum(final Node<K,T> node) {
        if(node == null) {
            return null;
        }

        Node<K,T> currentNode = node;
        while(currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    public K getMaximum() {
        if(root == null) {
            return null;
        }
        return getMaximum(root).key;
    }

    public K getMinimum() {
        if(root == null) {
            return null;
        }
        return getMinimum(root).key;
    }

    @VisibleForTesting
    protected Node<K,T> getMinimum(final Node<K,T> node) {
        if(node == null) {
            return null;
        }

        Node<K,T> currentNode = node;
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(final Node<K,T> node) {
        if(node == null) {
            return;
        }

        printTree(node.left);
        System.out.println(String.format("%s", node.key));
        printTree(node.right);

    }

    public List<K> getOrderedKeys() {
        final List<K> keys = new ArrayList<K>();
        writeOrderedKeys(root, keys);
        return keys;
    }

    private void writeOrderedKeys(final Node<K,T> node, final List<K> list) {
        if(node == null) {
            return;
        }

        writeOrderedKeys(node.left, list);
        list.add(node.key);
        writeOrderedKeys(node.right, list);
    }

    private Node<K,T> binarySearch(final K key) {
        Node<K,T> currentNode = root;
        while(currentNode != null) {
            final int comparisonResult = key.compareTo(currentNode.key);
            if(comparisonResult == 0) {
                return currentNode;
            } else if(comparisonResult < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return currentNode;
    }

    @VisibleForTesting
    protected Node<K,T> getRoot() {
        return root;
    }

    @VisibleForTesting
    protected static class Node<K extends Comparable<K>, T> {
        protected T value;
        protected K key;
        protected Node<K,T> left;
        protected Node<K,T> right;
        protected Node<K,T> parent;
    }
}
