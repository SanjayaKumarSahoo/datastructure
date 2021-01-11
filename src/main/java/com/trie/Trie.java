package com.trie;

import java.util.Map;

public class Trie {

    public final TrieNode trieNode;

    public Trie() {
        trieNode = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> childrens = trieNode.childrens;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode trieNode;
            if (childrens.containsKey(c)) {
                trieNode = childrens.get(c);
            } else {
                trieNode = new TrieNode();
                trieNode.content = c;
                childrens.put(c, trieNode);
            }
            childrens = trieNode.childrens;
            if (i == word.length() - 1) {
                trieNode.isLeaf = true;
            }
        }
    }

    public TrieNode searchNode(String search) {
        Map<Character, TrieNode> childrens = trieNode.childrens;
        TrieNode trieNode = null;
        for (int i = 0; i < search.length(); i++) {
            char c = search.charAt(i);
            if (childrens.containsKey(c)) {
                trieNode = childrens.get(c);
                childrens = trieNode.childrens;
            } else {
                return null;
            }
        }
        return trieNode;
    }

    public boolean searchPrefix(String prefix) {
        return searchNode(prefix) != null;
    }


    public static void main(String[] args) {

    }
}
