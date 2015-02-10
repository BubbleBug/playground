package com.y62wang.learn.linkedlist;

import com.y62wang.learn.basic.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListBuilderTest {

    private LinkedListBuilder<Integer> linkedListBuilder;

    @Before
    public void setUp() {
        linkedListBuilder = new LinkedListBuilder<Integer>();
    }

    @Test
    public void testNewBuilderBuildsNullLinkedList() {
        Node<Integer> head = linkedListBuilder.build();
        Assert.assertNull("a new linked-list builder should return null as list head.", head);
    }

    @Test
    public void testAddOneNodeBuildsAListOfLengthOne() {
        int value = 3;
        linkedListBuilder.addNode(value);
        Node<Integer> head = linkedListBuilder.build();
        Assert.assertEquals(Integer.valueOf(value), head.getValue());
        Assert.assertNull("The next node should be null", head.getNext());
    }

    @Test
    public void testAddNodesThreeTimesBuildsAListOfLengthThree() {
        int value = 3;
        linkedListBuilder.addNode(value);
        linkedListBuilder.addNode(value);
        linkedListBuilder.addNode(value);

        Node<Integer> head = linkedListBuilder.build();

        assertListLength(head, 3);
    }

    @Test
    public void testAddAListOfNodesBuildsAListWithTheSameLengthAsTheList() {
        List<Integer> numberList = new ArrayList<Integer>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);

        linkedListBuilder.addNodes(numberList);
        Node<Integer> head = linkedListBuilder.build();

        assertListLength(head, 4);
    }

    private void assertListLength(Node head, final int expectedLength) {
        int length = 0;
        Node currentNode = head;

        while(currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }

        Assert.assertEquals(length, expectedLength);
    }
}
