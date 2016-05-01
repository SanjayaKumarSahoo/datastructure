package com.linkedlist.circularlinkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CircularLinkedListTest {

	@Test
	public void testAddFirst() {
		CircularLinkedList list = new CircularLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		assertEquals(4, list.size());
		assertEquals("40 30 20 10 ", list.toString());

		assertEquals(list.getTail().getNext().getData(), 40);
		assertEquals(list.getHead().getNext().getNext().getData(), 20);
	}

	@Test
	public void testAddLast() {
		CircularLinkedList list = new CircularLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addLast(100);

		assertEquals(5, list.size());
		assertEquals("40 30 20 10 100 ", list.toString());
		list.addLast(200);
		assertEquals("40 30 20 10 100 200 ", list.toString());
		assertEquals(list.getTail().getData(), 200);
		assertEquals(list.getHead().getData(), 40);
		assertEquals(list.getTail().getNext().getData(), 40);
		assertEquals(list.getHead().getNext().getNext().getData(), 20);
	}

	@Test
	public void testAddByPosition() {
		CircularLinkedList list = new CircularLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.add(1, 30);
		list.add(1, 40);
		assertEquals(4, list.size());
		assertEquals("40 30 20 10 ", list.toString());

		list.add(3, 50);
		assertEquals("40 30 50 20 10 ", list.toString());

		assertEquals(list.getTail().getData(), 10);
		assertEquals(list.getHead().getData(), 40);
		assertEquals(list.getTail().getNext().getData(), 40);
		assertEquals(list.getHead().getNext().getNext().getData(), 50);
	}

	@Test
	public void testDeleteFirst() {
		CircularLinkedList list = new CircularLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.add(1, 30);
		list.add(1, 40);
		assertEquals(4, list.size());
		assertEquals("40 30 20 10 ", list.toString());

		list.deleteFirst();
		assertEquals(3, list.size());
		assertEquals("30 20 10 ", list.toString());

		list.deleteFirst();
		assertEquals("20 10 ", list.toString());

		list.deleteFirst();
		assertEquals("10 ", list.toString());

		list.deleteFirst();
		assertEquals("", list.toString());

		assertEquals(0, list.size());
		assertEquals("", list.toString());
	}

	@Test
	public void testDeleteLast() {
		CircularLinkedList list = new CircularLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.add(1, 30);
		list.add(1, 40);
		assertEquals(4, list.size());
		assertEquals("40 30 20 10 ", list.toString());

		list.deleteLast();
		assertEquals("40 30 20 ", list.toString());

		list.deleteLast();
		assertEquals("40 30 ", list.toString());

		list.deleteLast();
		list.deleteLast();
		assertEquals("", list.toString());
	}

	@Test
	public void testDeleteByPosition() {
		CircularLinkedList list = new CircularLinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.add(1, 30);
		list.add(1, 40);
		assertEquals(4, list.size());
		assertEquals("40 30 20 10 ", list.toString());

		list.delete(2);
		assertEquals("40 20 10 ", list.toString());

		assertEquals(list.getTail().getData(), 10);
		assertEquals(list.getHead().getData(), 40);
		assertEquals(list.getTail().getNext().getData(), 40);
		assertEquals(list.getHead().getNext().getNext().getData(), 10);

		list.deleteLast();
		assertEquals("40 20 ", list.toString());

		list.deleteFirst();
		assertEquals("20 ", list.toString());

		list.delete(1);
		assertEquals("", list.toString());

	}
}
