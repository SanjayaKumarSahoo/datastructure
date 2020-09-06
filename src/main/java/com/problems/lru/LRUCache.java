package com.problems.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;
    private Node<K, V> head;
    private Node<K, V> tail;
    private final Map<K, Node<K, V>> container;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.container = new HashMap<>();
    }

    public void put(K key, V value) {
        int currentSize = container.size();
        if (currentSize == capacity) {
            removeLast();
            addFirst(key, value);
        } else {
            Node<K, V> node = new Node<>();
            node.key = key;
            node.value = value;
            // first element
            if (head == null) {
                head = node;
                tail = node;
                container.put(key, node);
            } else {
                addFirst(key, value);
            }

        }
    }

    private void removeLast() {
        container.remove(tail.key);
        tail = tail.prev;
    }

    private void addFirst(K key, V value) {
        Node<K, V> node = new Node<>();
        node.key = key;
        node.value = value;
        node.next = head;
        node.prev = null;
        head = node;
        container.put(key, node);
    }

    public V get(K key) {
        Node<K, V> node = container.get(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");
        lruCache.put(4, "D");
        // evicted key
        System.out.println(lruCache.get(1));
        // cache hit key
        System.out.println(lruCache.get(4));
    }
}
