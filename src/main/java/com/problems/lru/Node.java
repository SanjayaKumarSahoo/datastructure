package com.problems.lru;

public class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> prev;
}
