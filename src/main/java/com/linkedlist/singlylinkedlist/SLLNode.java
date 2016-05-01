package com.linkedlist.singlylinkedlist;

public class SLLNode {

	private final int data;
	private SLLNode next;

	public SLLNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
	public SLLNode getNext() {
		return next;
	}

	public void setNext(SLLNode next) {
		this.next = next;
	}
}
