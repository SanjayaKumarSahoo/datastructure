package com.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    char content;
    Map<Character, TrieNode> childrens = new HashMap<>();
    boolean isLeaf;
}
