package com.y62wang.learn.linkedlist;

import com.y62wang.learn.basic.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveMiddleNodeAlgorithmTest {
    private LinkedListBuilder<Integer> builder;

    @Before
    public void setUp() {
        builder = new LinkedListBuilder<Integer>();
    }

    @Test
    public void testRemoveMiddleNodeFromNullLinkedListReturnsNullHead() {
        final RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm<Integer>(null);
        final Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertNull(result);
    }

    @Test
    public void testRemoveMiddleNodeFromSingleItemLinkedListReturnsNullHead() {
        builder.addNode(1);
        final RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm<Integer>(builder.build());
        final Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertNull(result);
    }

    @Test
    public void testRemoveMiddleNodeFromTwoItemLinkedListReturnsFirstNode() {
        builder.addNodes(1, 2);
        final Node<Integer> head = builder.build();
        final RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm<Integer>(head);
        final Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertSame(head, result);
        Assert.assertNull(result.getNext());
    }

    @Test
    public void testRemoveMiddleNodeFromThreeItemLinkedListReturnsFirstNode() {
        builder.addNodes(1,2,3);
        final Node<Integer> head = builder.build();
        final RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm<Integer>(head);
        final Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertSame(head, result);
        Assert.assertEquals(Integer.valueOf(3), head.getNext().getValue());
    }


    @Test
    public void testRemoveMiddleNodeFromMultipleItemsLinkedListReturnsFirstNode() {
        builder.addNodes(1,2,3,4,5,6,7,8,9);
        final Node<Integer> head = builder.build();
        final RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm<Integer>(head);
        final Node<Integer> result = removeMidNodeAlgorithm.run();

        Node<Integer> currentNode = result;

        while(currentNode != null) {
            Assert.assertFalse(Integer.valueOf(5).equals(currentNode.getValue()));
            currentNode = currentNode.getNext();
        }

    }
}
