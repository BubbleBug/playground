package com.y62wang.learn.interviews;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

public class LocalMaximaTest {
    private LocalMaxima localMaxima;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        localMaxima = new LocalMaxima();
    }

    @Test
    public void testNullInputThrowsNullPointerException() {
        expectedException.expect(NullPointerException.class);
        localMaxima.getLocalMaxima(null);
    }

    @Test
    public void testInputArrayWithSizeZeroThrowsIllegalStateException() {
        int[] numbers = new int[0];
        expectedException.expect(IllegalStateException.class);
        localMaxima.getLocalMaxima(numbers);
    }

    @Test
    public void testIntArrayWithOneElement() throws Exception {
        int[] numbers = new int[] {1};
        Assert.assertEquals(1, localMaxima.getLocalMaxima(numbers));
    }

    @Test
    public void testIntArrayWithTwoElement() throws Exception {
        int[] numbers = new int[] {1,2};
        Assert.assertEquals(2, localMaxima.getLocalMaxima(numbers));
    }

    @Test
    public void testIntArrayWithTwoElementInReverseOrder() throws Exception {
        int[] numbers = new int[] {2,1};
        Assert.assertEquals(2, localMaxima.getLocalMaxima(numbers));
    }

    @Test
    public void testIntArrayWithMultipleMaximaShouldReturnOneOfThePossibleLocalMaxima() throws Exception {
        int[] numbers = new int[] {2,1,1,3,2,5,6,8,2,};
        Set<Integer> possibleMaxima = new HashSet<Integer>();
        possibleMaxima.add(2);
        possibleMaxima.add(3);
        possibleMaxima.add(8);
        Assert.assertTrue(possibleMaxima.contains(localMaxima.getLocalMaxima(numbers)));
    }
}