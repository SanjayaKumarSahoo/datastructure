package com.linkedlist.circularlinkedlist;

public class CLLNode {

	private final int data;
	private CLLNode next;

	public CLLNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
	public CLLNode getNext() {
		return next;
	}

	public void setNext(CLLNode next) {
		this.next = next;
	}
}
