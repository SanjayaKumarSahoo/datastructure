package com.linkedlist.circularlinkedlist;

public class CircularLinkedList {

	private CLLNode head;
	private CLLNode tail;

	// insert a new node before the head, beginning of list
	public void addFirst(int data) {
		if (head == null) {
			head = new CLLNode(data);
			tail = head;
			tail.setNext(head);
		} else {
			CLLNode newNode = new CLLNode(data);
			newNode.setNext(head);
			head = newNode;
			tail.setNext(head);
		}
	}

	// insert a new node after the tail, end of list
	public void addLast(int data) {
		if (head == null) {
			addFirst(data);
		} else {
			CLLNode newNode = new CLLNode(data);
			tail.setNext(newNode);
			tail = newNode;
			tail.setNext(head);
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
				CLLNode currentNode = head;
				for (int i = 1; i < position - 1; i++) {
					currentNode = currentNode.getNext();
				}
				CLLNode currentNextNode = currentNode.getNext();
				CLLNode newNode = new CLLNode(data);
				currentNode.setNext(newNode);
				newNode.setNext(currentNextNode);
			}
		}
	}

	public void deleteFirst() {
		if (head == null) {
			throw new RuntimeException("List is empty");
		} else {
			if (size() == 1) {
				head = null;
				tail = null;
			} else {
				CLLNode nextToHead = head.getNext();
				tail.setNext(nextToHead);
				head = nextToHead;
			}
		}
	}

	public void deleteLast() {
		if (head == null) {
			throw new RuntimeException("List is empty");
		} else {
			if (size() == 1) {
				head = null;
				tail = null;
			} else {
				CLLNode currentNode = head;
				// this pointer is used to find previous node of tail
				CLLNode temp = null;
				while (currentNode.getNext() != head) {
					temp = currentNode;
					currentNode = currentNode.getNext();
				}
				temp.setNext(head);
				tail = temp;
			}
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
				CLLNode temp = head;
				for (int i = 1; i < position - 1; i++) {
					temp = temp.getNext();
				}
				CLLNode tempNextNext = temp.getNext().getNext();
				temp.setNext(tempNextNext);
			}
		}
	}

	public String toString() {
		CLLNode currentNode = head;
		StringBuilder builder = new StringBuilder();
		while (currentNode != null) {
			builder.append(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
			if (currentNode == head) {
				break;
			}
		}
		return builder.toString();
	}

	public int size() {
		CLLNode currentNode = head;
		int count = 0;
		while (currentNode != null) {
			count++;
			currentNode = currentNode.getNext();
			if (currentNode == head) {
				break;
			}
		}
		return count;
	}

	public CLLNode getHead() {
		return head;
	}

	public CLLNode getTail() {
		return tail;
	}

}
