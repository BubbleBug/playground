package com.y62wang.learn.bits;

import junit.framework.Assert;
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
        int x = 10, y = 10, z = 11;

        // anything XOR with 0 is itself
        Assert.assertEquals(x, x ^ 0);

        // any number XOR with itself is 0
        Assert.assertEquals(0, x ^ y);

        Assert.assertTrue(0 != (y ^ z));
    }

    @Test
    public void testDefiningXORUsingOtherLogicalOperators() {
        int x = 10, y = 100;
        // defining XOR without using the ^ symbol
        Assert.assertEquals(x ^ y, (x & ~y) | (y & ~x));
    }

    @Test
    public void testApplyXOREvenNumberOfTimesReturnsOriginalNumber() {
        int x = 10, y = 123, result = x;
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
        int setA = 12345, setB = 56789;

        int setUnion = (setA | setB);
        int setIntersection = (setA & setB);
        int setSubtraction = setA & ~setB;
        int setNegation = Integer.MAX_VALUE ^ setA;
        int setBit = setA | 1 << 5; // set the 5th bit
        int clearBit = setA & ~(1 << 5); // clear the 5th bit

        // first bit of setA should be set
        Assert.assertTrue((setA & 1) != 0);
    }

    @Test
    public void testFindFirstNoneEmptyBitInAnInteger() {
        int x = 10; // in binary: 1010, highestBit is 4th bit from right
        int result = 0;
        for(int bitShift=31;bitShift>=0;bitShift--) {
            if((x & (1 << bitShift)) != 0) {
                result = bitShift;
                break;
            }
        }
        Assert.assertEquals(3, result);
    }

}
