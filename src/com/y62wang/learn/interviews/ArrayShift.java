package com.y62wang.learn.interviews;


import com.google.common.base.Preconditions;
import sun.reflect.generics.tree.ArrayTypeSignature;

import java.util.Arrays;

public class ArrayShift {

    public int[] shiftArray(int[] array, int shift) {
        Preconditions.checkNotNull(array);

        if(array.length == 0) {
            return array;
        }

        final int length = array.length;
        shift = index(shift, length);

        if(shift == 0) {
            return array;
        }

        int replaceVal = array[0], temp, curr = shift;
        for (int i = 0; i < array.length; i++) {
            if (array.length % shift == 0 && i != 0 && i % (array.length / shift) == 0) {
                replaceVal = array[index(curr + 1, length)];
                curr = index(curr + 1 + shift, length);
            }
            temp = array[curr];
            array[curr] = replaceVal;
            replaceVal = temp;
            curr = index(shift + curr, length);
        }
        return array;
    }

    public int[] shiftArrayByReversing(int[] array, int shift) {
        Preconditions.checkNotNull(array);
        shift = index(shift, array.length);

        reverse(array, 0, array.length - 1);
        reverse(array, 0, shift - 1);
        reverse(array, shift, array.length - 1);
        return array;
    }

    private void reverse(int[] array, int start, int end) {
        for (;start<end;start++,end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }

    private int index(int index, int arraySize) {
        int actualIndex = index % arraySize;
        if (actualIndex < 0) {
            actualIndex += arraySize;
        }
        return actualIndex;
    }
}
