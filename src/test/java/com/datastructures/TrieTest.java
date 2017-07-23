package com.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {
    @Test
    public void search_string_efficiently() {
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("append");
        trie.add("ant");

        System.out.println(trie);
        Assert.assertTrue(trie.find("apple"));
        Assert.assertFalse(trie.find("aptitude"));
    }
}
