package com.y62wang.learn.bits;

import junit.framework.Assert;
import org.junit.Test;

public class BitManipulationTest {

    @Test
    public void SwappingTwoIntegersShouldExchangeValuesOfDefinedVariables() {
        int x = 10, y = 99;

        // perform swapping without using a temporary variable
        x = x ^ y;
        y = x ^ y;
        x = y ^ x;

        // (x XOR y) XOR x = y
        // (x XOR y) XOR y = x

        Assert.assertEquals(99, x);
        Assert.assertEquals(10, y);
    }
}
