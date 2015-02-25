package com.y62wang.learn.interviews;

import com.google.common.base.Preconditions;

/**
 * Determine the local maxima of an array of integers
 */
public class LocalMaxima {

    public int getLocalMaxima(final int[] numbers) {
        Preconditions.checkNotNull(numbers, "Input array should not be null.");
        Preconditions.checkState(numbers.length > 0, "Input array should at least have one element.");

        int left = 0, right = numbers.length - 1;
        while (left != right) {
            final int mid = left + (right - left) / 2;

            if (numbers[mid] < numbers[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return numbers[left];
    }
}
