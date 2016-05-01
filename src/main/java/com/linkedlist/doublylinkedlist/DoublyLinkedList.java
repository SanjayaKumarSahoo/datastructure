package com.linkedlist.doublylinkedlist;

public class DoublyLinkedList {

	private DLLNode head;
	private DLLNode tail;

	// insert a new node before the head, beginning of list
	public void addFirst(int data) {
		if (head == null) {
			head = new DLLNode(data);
			head.setNext(null);
			head.setPrevious(null);
			tail = head;
		} else {
			DLLNode newNode = new DLLNode(data);
			newNode.setNext(head);
			head.setPrevious(newNode);
			newNode.setPrevious(null);
			head = newNode;
		}
	}

	// insert a new node after the tail, end of list
	public void addLast(int data) {
		if (head == null) {
			addFirst(data);
		} else {
			DLLNode newNode = new DLLNode(data);
			tail.setNext(newNode);
			newNode.setPrevious(tail);
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
				DLLNode temp = head;
				for (int i = 1; i < position - 1; i++) {
					temp = temp.getNext();
				}
				DLLNode tempNextNode = temp.getNext();
				DLLNode newNode = new DLLNode(data);
				newNode.setPrevious(temp);
				temp.setNext(newNode);
				newNode.setNext(tempNextNode);
				tempNextNode.setPrevious(newNode);
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
				DLLNode nextToHead = head.getNext();
				nextToHead.setPrevious(null);
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
				DLLNode previousToTail = tail.getPrevious();
				previousToTail.setNext(null);
				tail = previousToTail;
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
				DLLNode temp = head;
				for (int i = 1; i < position - 1; i++) {
					temp = temp.getNext();
				}
				DLLNode tempNextNext = temp.getNext().getNext();
				temp.setNext(tempNextNext);
				tempNextNext.setPrevious(temp);
			}
		}
	}

	public String toString() {
		DLLNode temp = head;
		StringBuilder builder = new StringBuilder();
		while (temp != null) {
			builder.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return builder.toString();
	}

	public int size() {
		DLLNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	public DLLNode getHead() {
		return head;
	}

	public DLLNode getTail() {
		return tail;
	}

}
