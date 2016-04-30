package com.linkedlist.singlylinkedlist;

public class SinglyLinkedList {

	private Node head = null;
	private Node tail = null;

	// insert a new node before the head, beginning of list
	public void addFirst(int data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		} else {
			Node newNode = new Node(data);
			newNode.setNext(head);
			head = newNode;
		}
	}

	// insert a new node after the tail, end of list
	public void addLast(int data) {
		if (head == null) {
			head = new Node(data);
			head.setNext(null);
			tail = head;
		} else {
			Node newNode = new Node(data);
			tail.setNext(newNode);
			newNode.setNext(null);
			tail = newNode;
		}
	}

	// inserassertTruet in any location, based on index
	public void add(int position, int data) {
		if (position <= 0 || position - size() > 1) {
			throw new RuntimeException("Invalid position");
		} else {
			if (position - size() == 1) {
				// if position 1 and size 0, add to last
				// if position 2 and size 1, add to last
				// if position 3 and size 2, add to last
				// and so on ..
				addLast(data);
			} else {
				// add to middle
				// create a temp node and traverse to the position - 1 node
				Node temp = head;
				for (int i = 1; i < position - 1; i++) {
					temp = temp.getNext();
				}
				Node tempNextNode = temp.getNext();
				Node newNode = new Node(data);
				temp.setNext(newNode);
				newNode.setNext(tempNextNode);
			}
		}
	}

	public void deleteFirst() {
		if (head == null) {
			throw new RuntimeException("List is empty");
		} else {
			Node temp = head.getNext();
			head = temp;
		}
	}

	public void deleteLast() {
		if (head == null) { // if position 1 and size 1, delete from last
			// if position 2 and size 2, delete from last
			// if position 3 and size32, delete from last

			throw new RuntimeException("List is empty");
		} else if (head == tail) {
			head = null;
		} else {
			Node temp = head;
			Node tailLessOne = null;
			while (temp.getNext() != null) {
				tailLessOne = temp;
				temp = temp.getNext();
			}
			tail = tailLessOne;
			tail.setNext(null);

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
				Node temp = head;
				for (int i = 1; i < position - 1; i++) {
					temp = temp.getNext();
				}
				Node tempNextNext = temp.getNext().getNext();
				temp.setNext(tempNextNext);
			}
		}
	}

	public String toString() {
		Node temp = head;
		StringBuilder builder = new StringBuilder();
		while (temp != null) {
			builder.append(temp.getData() + " ");
			temp = temp.getNext();
		}
		return builder.toString();
	}

	public int size() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
}
