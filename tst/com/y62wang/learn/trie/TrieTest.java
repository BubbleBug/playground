package com.y62wang.learn.trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TrieTest {

    private static final String TEST_STRING = "cat";
    private static final String TEST_STRING_2 = "cabbage";
    private static final String EMPTY_STRING = "";
    private static final String UPPER_CASE_WORD = "UPPERCASE";

    private Trie trie;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        this.trie = new Trie();
    }

    @Test
    public void testEmptyTrieDoesNotContainAnEmptyString() throws TrieException {
        Assert.assertFalse(trie.contains(EMPTY_STRING));
    }

    @Test
    public void testTrieDoesNotContainArbitraryString() throws TrieException {
        Assert.assertFalse(trie.contains(TEST_STRING));
    }

    @Test
    public void testTrieWithOneElementShouldContainThatElement() throws TrieException {
        trie.add(TEST_STRING);
        Assert.assertTrue(trie.contains(TEST_STRING));
    }

    @Test
    public void testTrieWithTwoElementShouldContainThoseTwoElements() throws TrieException {
        trie.add(TEST_STRING);
        trie.add(TEST_STRING_2);
        Assert.assertTrue(trie.contains(TEST_STRING));
        Assert.assertTrue(trie.contains(TEST_STRING_2));
    }

    @Test
    public void testAddingWordWithUppercaseThrowsTrieException() throws TrieException {
        expectedException.expect(TrieException.class);
        expectedException.expectMessage("The character 'U' is not part of the alphabet.");
        trie.add(UPPER_CASE_WORD);
    }

    @Test
    public void testTrieShouldNotContainWordAfterItIsRemoved() throws TrieException {
        trie.add(TEST_STRING);
        Assert.assertTrue(trie.contains(TEST_STRING));

        trie.remove(TEST_STRING);
        Assert.assertFalse(trie.contains(TEST_STRING));
    }
}