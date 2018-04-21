package com.stack;

import com.linkedlist.singlylinkedlist.SinglyLinkedList;

public class LinkListBasedStack<T> {

    private final SinglyLinkedList<T> list;

    public LinkListBasedStack() {
        list = new SinglyLinkedList();
    }

    public void push(T data) {
        list.addLast(data);
    }

    public T pop() {
        return list.deleteLast();
    }

    public boolean isEmpty() {
        return list.getHead() == null;
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
