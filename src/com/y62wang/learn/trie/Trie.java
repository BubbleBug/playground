package com.y62wang.learn.trie;

/**
 * A trie (prefix tree) used to store data with a set of keys and values
 * <p/>
 * Properties of a trie:
 * The root is an empty string
 * All the descendants of a node have a common prefix
 * Values are normally associated with every node, only leaves and some inner nodes that
 * correspond to key of interest
 *
 * space complexity: O(ALPHABET_SIZE * average_key_length * N)
 * look-up: O(m) where m is the length of the word
 * add: O(m) where m is the length of the word
 */
public class Trie {
    private static final char STARTING_ALPHABET = 'a';
    private static final char ENDING_ALPHABET = 'z';

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(final String word) throws TrieException {
        TrieNode currentNode = root;
        for (final char key : word.toCharArray()) {
            if (currentNode.getChild(key) == null) {
                currentNode.addChild(key);
            }
            currentNode = currentNode.getChild(key);
        }
        currentNode.setValue(1);
    }

    public void remove(final String word) throws TrieException {
        final TrieNode valueNode = getValueNode(word);

        if (valueNode == null) {
            return;
        }

        valueNode.setValue(0);
        removeSubtree(root);
    }

    private TrieNode getValueNode(final String word) throws TrieException {
        TrieNode currentNode = root;
        for (final char key : word.toCharArray()) {
            if (currentNode.getChild(key) == null) {
                return null;
            }
            currentNode = currentNode.getChild(key);
        }
        return currentNode.getValue() == 0 ? null : currentNode;
    }

    private boolean removeSubtree(final TrieNode root) {
        if (root == null) {
            return true;
        }

        if (root.getChildrenCount() == 0) {
            return root.getValue() == 0;
        }

        for (int i = 0; i < root.getChildren().length; i++) {
            final TrieNode child = root.getChildren()[i];
            if (removeSubtree(child) == false) {
                return false;
            } else {
                root.removeChild(i);
            }
        }
        return true;
    }

    public boolean contains(final String word) throws TrieException {
        return getValueNode(word) != null;
    }

    private class TrieNode {
        private int value;
        private final TrieNode[] children;
        private int childrenCount = 0;

        public TrieNode() {
            this(0);
        }

        public TrieNode(final int value) {
            this.value = value;
            children = new TrieNode[ENDING_ALPHABET - STARTING_ALPHABET + 1];
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        private int getAlphabetIndex(final char key) throws TrieException {
            if (key >= STARTING_ALPHABET && key <= ENDING_ALPHABET) {
                return key - STARTING_ALPHABET;
            }
            throw new TrieException(String.format("The character '%c' is not part of the alphabet.", key));
        }

        public TrieNode getChild(final char key) throws TrieException {
            final int index = getAlphabetIndex(key);
            return children[index];
        }

        public void addChild(final char key) throws TrieException {
            final int index = getAlphabetIndex(key);
            if (children[index] != null) {
                return;
            }
            children[index] = new TrieNode();
            childrenCount++;
        }

        public void removeChild(final int index) {
            if (children[index] == null) {
                return;
            }

            children[index] = null;
            childrenCount--;
        }

        public void removeChild(final char key) throws TrieException {
            final int index = getAlphabetIndex(key);
            removeChild(index);
        }

        public int getChildrenCount() {
            return childrenCount;
        }

        public TrieNode[] getChildren() {
            return this.children;
        }
    }
}
