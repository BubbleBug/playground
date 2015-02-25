package com.y62wang.learn.trees.bst;

import com.y62wang.learn.TestConstants;
import com.y62wang.learn.utils.BatchInputGenerator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class BinarySearchTreeTest {

    private BatchInputGenerator<Integer> integerBatchInputGenerator;
    private BinarySearchTree<Integer, Integer> bst;

    @Before
    public void setUp() throws Exception {
        integerBatchInputGenerator = new BatchInputGenerator<Integer>(TestConstants.INTEGER_GENERATOR);
        bst = new BinarySearchTree<Integer, Integer>();
    }

    @Test
    public void testMinMaxSucessorPredecessor() {
        final List<Integer> integers = integerBatchInputGenerator.generateBatch(100);
        for (final Integer integer : integers) {
            bst.insert(integer, integer);
        }

        BinarySearchTree.Node<Integer, Integer> min = bst.getMinimum(bst.getRoot());
        for(int i=0;i<integers.size()-1;i++) {
            final BinarySearchTree.Node<Integer, Integer> successor = bst.getSuccessor(min);
            Assert.assertTrue(successor.key.compareTo(min.key)>=0);
            min = successor;
        }

        BinarySearchTree.Node<Integer, Integer> max = bst.getMaximum(bst.getRoot());
        for(int i=0;i<integers.size()-1;i++) {
            final BinarySearchTree.Node<Integer, Integer> predecessor = bst.getPredecessor(max);
            Assert.assertTrue(predecessor.key.compareTo(min.key)<=0);
            max = predecessor;
        }
    }

    @Test
    public void testValidateBinarySearchTree() throws Exception {
        final List<Integer> integers = integerBatchInputGenerator.generateBatch(100);
        for(final Integer integer : integers) {
            bst.insert(integer, integer);
        }

        validateOrderedKeys();

        for(final Integer integer : integers) {
            bst.delete(integer);
        }
    }

    @Ignore
    @Test
    public void testAverageTreeHeightForRandomlyBuiltTrees() {
        final int count = 100;
        int totalHeight = 0;
        for(int i=0;i<count;i++) {
            final List<Integer> integers = integerBatchInputGenerator.generateBatch(100000);
            bst = new BinarySearchTree<Integer, Integer>();
            for(final Integer integer : integers) {
                bst.insert(integer, integer);
            }
            final int height = bst.height();
            totalHeight += height;
            System.out.println("Height: " + height);
        }
        System.out.println("Average tree height:" + totalHeight/count);
    }

    private void validateOrderedKeys() {
        final List<Integer> orderedKeys = bst.getOrderedKeys();
        if(orderedKeys.size()==0) {
            return;
        }
        Integer first = orderedKeys.get(0);

        for (final Integer orderedKey : orderedKeys) {
            if(orderedKey<first) {
                throw new RuntimeException();
            }
            first = orderedKey;
        }
    }

}