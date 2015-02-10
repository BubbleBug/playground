package com.y62wang.learn.linkedlist;

import com.y62wang.learn.basic.Node;
import junit.framework.Assert;
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
        RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm(null);
        Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertNull(result);
    }

    @Test
    public void testRemoveMiddleNodeFromSingleItemLinkedListReturnsNullHead() {
        builder.addNode(1);
        RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm(builder.build());
        Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertNull(null);
    }

    @Test
    public void testRemoveMiddleNodeFromTwoItemLinkedListReturnsFirstNode() {
        builder.addNodes(1, 2);
        Node<Integer> head = builder.build();
        RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm(head);
        Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertEquals(head, result);
        Assert.assertNull(result.getNext());
    }

    @Test
    public void testRemoveMiddleNodeFromThreeItemLinkedListReturnsFirstNode() {
        builder.addNodes(1,2,3);
        Node<Integer> head = builder.build();
        RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm(head);
        Node<Integer> result = removeMidNodeAlgorithm.run();
        Assert.assertEquals(head, result);
        Assert.assertEquals(Integer.valueOf(3), head.getNext().getValue());
    }


    @Test
    public void testRemoveMiddleNodeFromMultipleItemsLinkedListReturnsFirstNode() {
        builder.addNodes(1,2,3,4,5,6,7,8,9);
        Node<Integer> head = builder.build();
        RemoveMiddleNodeAlgorithm<Integer> removeMidNodeAlgorithm = new RemoveMiddleNodeAlgorithm(head);
        Node<Integer> result = removeMidNodeAlgorithm.run();

        Node currentNode = result;

        while(currentNode != null) {
            Assert.assertFalse(Integer.valueOf(5).equals(currentNode.getValue()));
            currentNode = currentNode.getNext();
        }

    }
}
