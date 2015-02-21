package com.y62wang.learn.trees.heap;

/**
 * Heap
 *           Average     Worst Case
 * Space:    O(n)        O(n)
 * Search:   O(n)        O(n)
 * Insert:   O(log n)    O(log n)
 * Delete:   O(log n)    O(log n)
 *
 */
public class Heap<T extends Comparable<T>> {
    private final T[] data;

    public Heap(final T[] data) {
        this.data = data;
    }

    public void build() {
        int index=data.length/2;
        while(index >= 0) {
            if(data[index] != null) {
                maxify(data, index);
            }
            index--;

        }
    }

    private void maxify(final T[] data, final int nodeIndex) {
        final int left = getLeft(nodeIndex);
        final int right = getRight(nodeIndex);
        int largest=nodeIndex;

        if(left < data.length && data[left] != null && data[largest].compareTo(data[left]) < 0) {
            largest = left;
        }

        if(right < data.length && data[right] != null && data[largest].compareTo(data[right]) < 0) {
            largest = right;
        }

        if(largest != nodeIndex) {
            final T temp = data[nodeIndex];
            data[nodeIndex] = data[largest];
            data[largest] = temp;
            maxify(data, largest);
        }
    }

    private int getLeft(final int currentIndex) {
        return currentIndex*2+1;
    }

    private int getRight(final int currentIndex) {
        return (currentIndex+1)*2;
    }
}
