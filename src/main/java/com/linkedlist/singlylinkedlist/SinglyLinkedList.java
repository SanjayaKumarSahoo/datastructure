package com.linkedlist.singlylinkedlist;

public class SinglyLinkedList {

	private SLLNode head = null;
	private SLLNode tail = null;

	// insert a new node before the head, beginning of list
	public void addFirst(int data) {
		if (head == null) {
			head = new SLLNode(data);
			tail = head;
		} else {
			SLLNode newNode = new SLLNode(data);
			newNode.setNext(head);
			head = newNode;
		}
	}

	// insert a new node after the tail, end of list
	public void addLast(int data) {
		if (head == null) {
			head = new SLLNode(data);
			head.setNext(null);
			tail = head;
		} else {
			SLLNode newNode = new SLLNode(data);
			tail.setNext(newNode);
			newNode.setNext(null);
			tail = newNode;
		}
	}

	// insert at any location, based on index
	public void add(int position, int data) {
		if (position <= 0 || position - size() > 1) {
			throw new RuntimeException("Invalid position");
		} else {
			if (position == 1) {
				addFirst(data);
			} else if (position - size() == 1) {
				// if position 1 and size 0, add to last
				// if position 2 and size 1, add to last
				// if position 3 and size 2, add to last
				// and so on ..
				addLast(data);
			} else {
				// add to middle
				// create a temp node and traverse to the position - 1 node
				SLLNode temp = head;
				for (int i = 1; i < position - 1; i++) {
					temp = temp.getNext();
				}
				SLLNode tempNextNode = temp.getNext();
				SLLNode newNode = new SLLNode(data);
				temp.setNext(newNode);
				newNode.setNext(tempNextNode);
			}
		}
	}

	public Integer deleteFirst() {
		if (head == null) {
			throw new RuntimeException("List is empty");
		} else {
			Integer daletedData = head != null ? head.getData() : null;
			SLLNode temp = head.getNext();
			head = temp;
			return daletedData;
		}
	}

	public int deleteLast() {
		if (head == null) {
			throw new RuntimeException("List is empty");
		} else if (head == tail) {
			int deletedNodeData = head.getData();
			head = null;
			return deletedNodeData;
		} else {
			SLLNode temp = head;
			SLLNode tailLessOne = null;
			while (temp.getNext() != null) {
				tailLessOne = temp;
				temp = temp.getNext();
			}
			int deletedNodeData = tail.getData();
			tail = tailLessOne;
			tail.setNext(null);
			return deletedNodeData;
		}
	}

	public void delete(int position) {
		if (position <= 0 || position > size()) {
			throw new RuntimeException("Invalid position");
		} else if (position == 1) {
			deleteFirst();
		} else {
			if (position == size()) {
				deleteLast();
			} else {
				// delete by position
				// create a temp node and traverse to the position - 1 node
				SLLNode temp = head;
				for (int i = 1; i < position - 1; i++) {
					temp = temp.getNext();
				}
				SLLNode tempNextNext = temp.getNext().getNext();
				temp.setNext(tempNextNext);
			}
		}
	}

	public String toString() {
		SLLNode temp = head;
		StringBuilder builder = new StringBuilder();
		while (temp != null) {
			builder.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return builder.toString();
	}

	public int size() {
		SLLNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public SLLNode getHead() {
		return head;
	}

	public SLLNode getTail() {
		return tail;
	}
}
