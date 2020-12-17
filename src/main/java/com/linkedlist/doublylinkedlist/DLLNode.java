package com.linkedlist.doublylinkedlist;

public class DLLNode {

    private final int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }
}
