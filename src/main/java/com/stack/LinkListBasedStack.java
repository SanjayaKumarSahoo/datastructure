package com.stack;

import com.linkedlist.singlylinkedlist.SinglyLinkedList;

public class LinkListBasedStack {

	private final SinglyLinkedList list;

	public LinkListBasedStack() {
		list = new SinglyLinkedList();
	}

	public void push(int data) {
		list.addLast(data);
	}

	public int pop() {
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
