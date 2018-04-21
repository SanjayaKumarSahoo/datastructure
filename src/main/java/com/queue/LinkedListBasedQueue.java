package com.queue;

import com.linkedlist.singlylinkedlist.SinglyLinkedList;

public class LinkedListBasedQueue<T> {

    private final SinglyLinkedList<T> list;

    public LinkedListBasedQueue() {
        list = new SinglyLinkedList<>();
    }

    public void enQueue(T data) {
        list.addLast(data);
    }

    public T deQueue() {
        if (getSize() == 0) {
            throw new RuntimeException("Queue empty");
        } else {
            return list.deleteFirst();
        }

    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
