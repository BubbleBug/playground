package com.y62wang.learn.interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayShiftTest {

    private ArrayShift arrayShift;

    @Before
    public void setUp() throws Exception {
        arrayShift = new ArrayShift();
    }

    @Test
    public void testShiftingEmptyArray() {
        int[] array = new int[0];
        final int[] result = arrayShift.shiftArray(array, 3);
        assertEquals(0, result.length);
    }

    @Test
    public void testShiftingOneElementArray() {
        int[] array = new int[] {1};
        int[] result = arrayShift.shiftArray(array, 3);
        assertEquals(1, result[0]);

        result = arrayShift.shiftArrayByReversing(array, 3);
        assertEquals(1, result[0]);
    }

    @Test
    public void testShiftingOneElementArrayUsingNegativeShift() {
        int[] array = new int[] {1};
        int[] result = arrayShift.shiftArray(array, -2);
        assertEquals(1, result[0]);

        result = arrayShift.shiftArrayByReversing(array, -2);
        assertEquals(1, result[0]);
    }

    @Test
    public void testShiftingTwoElementArray() {
        int[] array = new int[] {1,2};
        int[] result = arrayShift.shiftArray(array, 1);
        assertEquals(2, result[0]);
        assertEquals(1, result[1]);

        result = arrayShift.shiftArrayByReversing(array, 1);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void testShiftingTwoElementArrayUsingNegativeShift() {
        int[] array = new int[] {1,2};
        int[] result = arrayShift.shiftArray(array, -3);
        assertEquals(2, result[0]);
        assertEquals(1, result[1]);

        result = arrayShift.shiftArrayByReversing(array, -3);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void testShiftingABigArray() {
        int[] array = new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
        int[] expected = new int[] {9,10,11,0,1,2,3,4,5,6,7,8};
        assertArrayEquals(expected, arrayShift.shiftArray(Arrays.copyOf(array, array.length), 3));
        assertArrayEquals(expected, arrayShift.shiftArrayByReversing(Arrays.copyOf(array, array.length), 3));
    }
}