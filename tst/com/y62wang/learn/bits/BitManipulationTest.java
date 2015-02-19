package com.y62wang.learn.bits;

import org.junit.Assert;
import org.junit.Test;

public class BitManipulationTest {

    @Test
    public void testSwappingTwoIntegersShouldExchangeValuesOfDefinedVariables() {
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

    @Test
    public void testTwoNumbersAreEqualUsingXOR() {
        final int x = 10;
        final int y = 10;
        final int z = 11;

        // anything XOR with 0 is itself
        Assert.assertEquals(x, x ^ 0);

        // any number XOR with itself is 0
        Assert.assertEquals(0, x ^ y);

        Assert.assertTrue(0 != (y ^ z));
    }

    @Test
    public void testDefiningXORUsingOtherLogicalOperators() {
        final int x = 10;
        final int y = 100;
        // defining XOR without using the ^ symbol
        Assert.assertEquals(x ^ y, (x & ~y) | (y & ~x));
    }

    @Test
    public void testApplyXOREvenNumberOfTimesReturnsOriginalNumber() {
        final int x = 10;
        final int y = 123;
        int result = x;
        for(int i = 0;i<10;i++) {
            result = result ^ y;
        }

        Assert.assertEquals(x, result);
    }

    @Test
    public void testBitShiftingAsMultiplicationForPositiveNumbers() {
        // multiplying by 2^10
        Assert.assertEquals(1024, 1 << 10);

        // dividing by 2^3
        Assert.assertEquals(1, 8 >> 3);
    }

    @Test
    public void testUsingIntegerAsASet() {
        // using the 32 bits as a set, where value 1 in a bit means the object is in the set
        final int setA = 12345;
        final int setB = 56789;

        final int setUnion = (setA | setB);
        final int setIntersection = (setA & setB);
        final int setSubtraction = setA & ~setB;
        final int setNegation = Integer.MAX_VALUE ^ setA;
        final int setBit = setA | 1 << 5; // set the 5th bit
        final int clearBit = setA & ~(1 << 5); // clear the 5th bit

        // first bit of setA should be set
        Assert.assertTrue((setA & 1) != 0);
    }

    @Test
    public void testFindFirstNoneEmptyBitInAnInteger() {
        final int x = 10; // in binary: 1010, highestBit is 4th bit from right
        int result = 0;
        for(int bitShift=31;bitShift>0;bitShift--) {
            if((x & (1 << bitShift)) != 0) {
                result = bitShift;
                break;
            }
        }
        Assert.assertEquals(3, result);
    }

}
