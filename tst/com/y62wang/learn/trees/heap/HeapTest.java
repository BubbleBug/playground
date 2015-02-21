package com.y62wang.learn.trees.heap;

import com.y62wang.learn.TestConstants;
import com.y62wang.learn.utils.BatchInputGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HeapTest {


    private BatchInputGenerator<Integer> integerBatchInputGenerator;

    @Before
    public void setUp() throws Exception {
        integerBatchInputGenerator = new BatchInputGenerator<Integer>(TestConstants.INTEGER_GENERATOR);
    }

    @Test
    public void testCreateHeapWithOneElement() throws Exception {
        final Integer[] data = new Integer[] {1};
        final Heap<Integer> heap = new Heap<Integer>(data);
        heap.build();
        validateHeapProperty(data);
    }

    @Test
    public void testHeapConversionFromRandomInput() throws Exception {
        final int count = 5;
        final int inputSizeIncrement = 1000;
        for(int i=0;i<count;i++) {
            final List<Integer> integers = integerBatchInputGenerator.generateBatch(inputSizeIncrement * (1+i));
            Integer[] intArray = new Integer[integers.size()];
            intArray = integers.toArray(intArray);

            final Heap<Integer> heap = new Heap<Integer>(intArray);
            heap.build();

            validateHeapProperty(intArray);
        }
    }


    private void validateHeapProperty(final Integer[] data) {
        for(int i=0;i<data.length;i++) {
            final int left= i*2+1;
            final int right = left+1;
            if(left<data.length && data[left] != null) {
                Assert.assertTrue(String.format("Parent '%s' should not be smaller than Left '%s'", data[i], data[left]),
                        data[left] <= data[i]);
            }

            if(right<data.length && data[right] != null) {
                Assert.assertTrue(String.format("Parent '%s' should not be smaller than Right '%s'", data[i], data[right]),
                        data[right] <= data[i]);
            }
        }
    }
}