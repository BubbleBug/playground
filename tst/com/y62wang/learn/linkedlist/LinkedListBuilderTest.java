package com.y62wang.learn.linkedlist;

import com.y62wang.learn.basic.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListBuilderTest {

    private LinkedListBuilder<Integer> linkedListBuilder;

    @Before
    public void setUp() {
        linkedListBuilder = new LinkedListBuilder<Integer>();
    }

    @Test
    public void testNewBuilderBuildsNullLinkedList() {
        final Node<Integer> head = linkedListBuilder.build();
        Assert.assertNull("a new linked-list builder should return null as list head.", head);
    }

    @Test
    public void testAddOneNodeBuildsAListOfLengthOne() {
        final int value = 3;
        linkedListBuilder.addNode(value);
        final Node<Integer> head = linkedListBuilder.build();
        Assert.assertEquals(Integer.valueOf(value), head.getValue());
        Assert.assertNull("The next node should be null", head.getNext());
    }

    @Test
    public void testAddNodesThreeTimesBuildsAListOfLengthThree() {
        final int value = 3;
        linkedListBuilder.addNode(value);
        linkedListBuilder.addNode(value);
        linkedListBuilder.addNode(value);

        final Node<Integer> head = linkedListBuilder.build();

        assertListLength(head, 3);
    }

    @Test
    public void testAddAListOfNodesBuildsAListWithTheSameLengthAsTheList() {
        linkedListBuilder.addNodes(1, 2, 3, 4);
        final Node<Integer> head = linkedListBuilder.build();

        assertListLength(head, 4);
    }

    private void assertListLength(final Node head, final int expectedLength) {
        int length = 0;
        Node currentNode = head;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }

        Assert.assertEquals(length, expectedLength);
    }
}
