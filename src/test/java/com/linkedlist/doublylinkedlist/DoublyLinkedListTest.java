package com.linkedlist.doublylinkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DoublyLinkedListTest {

	@Test
	public void testAddFirst() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(100);
		list.addFirst(90);
		list.addFirst(80);
		list.addFirst(70);

		assertEquals("70 80 90 100 ", list.toString());
		assertEquals(list.getHead().getData(), 70);
		assertEquals(list.getHead().getNext().getData(), 80);
		assertEquals(list.getHead().getPrevious(), null);
	}

	@Test
	public void testAddLast() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast(100);
		list.addLast(90);
		assertEquals("100 90 ", list.toString());

		list.addFirst(1);
		assertEquals("1 100 90 ", list.toString());

		list.addLast(2);
		assertEquals("1 100 90 2 ", list.toString());

		assertEquals(list.getHead().getData(), 1);
		assertEquals(list.getHead().getNext().getData(), 100);
		assertEquals(list.getHead().getPrevious(), null);

		assertEquals(list.getTail().getData(), 2);
		assertEquals(list.getTail().getPrevious().getData(), 90);
		assertEquals(list.getTail().getNext(), null);
		assertEquals(list.getTail().getPrevious().getPrevious().getPrevious().getData(), 1);
	}

	@Test
	public void testAddByPosition() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(1, 100);
		assertEquals("100 ", list.toString());

		list.add(2, 102);
		assertEquals("100 102 ", list.toString());

		list.add(2, 101);
		assertEquals("100 101 102 ", list.toString());

		assertEquals(list.getHead().getData(), 100);
		assertEquals(list.getHead().getNext().getData(), 101);
		assertEquals(list.getHead().getNext().getNext().getData(), 102);
		assertEquals(list.getHead().getPrevious(), null);

		assertEquals(list.getTail().getData(), 102);
		assertEquals(list.getTail().getPrevious().getData(), 101);
		assertEquals(list.getTail().getPrevious().getNext().getData(), 102);
		assertEquals(list.getTail().getNext(), null);

		DoublyLinkedList list1 = new DoublyLinkedList();
		list1.add(1, 100);
		list1.addFirst(101);
		list1.addLast(102);
		assertEquals("101 100 102 ", list1.toString());
	}

	@Test
	public void testDeleteFirst() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(1, 100);
		list.add(2, 101);
		list.addLast(103);
		list.addFirst(99);
		assertEquals("99 100 101 103 ", list.toString());
		list.deleteFirst();
		assertEquals("100 101 103 ", list.toString());
		list.deleteFirst();
		assertEquals("101 103 ", list.toString());

		assertEquals(list.getTail().getPrevious().getData(), 101);
		assertEquals(list.getTail().getPrevious().getNext().getData(), 103);
	}

	@Test
	public void testDeleteLast() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(1, 100);
		list.add(2, 101);
		list.addLast(103);
		list.addFirst(99);
		list.deleteFirst();
		assertEquals("100 101 103 ", list.toString());
		list.add(2, 9999);
		assertEquals("100 9999 101 103 ", list.toString());

		list.deleteLast();
		assertEquals("100 9999 101 ", list.toString());

		list.deleteLast();
		assertEquals("100 9999 ", list.toString());

		assertEquals(list.getTail().getPrevious().getData(), 100);
		assertEquals(list.getTail().getPrevious().getNext().getData(), 9999);

	}

	@Test
	public void testDeleteByPosiiton() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(1, 100);
		list.add(2, 101);
		list.addLast(103);
		list.addFirst(99);
		list.delete(2);
		assertEquals("99 101 103 ", list.toString());

		list.add(2, 9999);
		assertEquals("99 9999 101 103 ", list.toString());

		list.deleteLast();
		assertEquals("99 9999 101 ", list.toString());

		list.deleteLast();
		assertEquals("99 9999 ", list.toString());

		list.delete(1);
		assertEquals("9999 ", list.toString());

		list.delete(1);
		assertEquals("", list.toString());

		list.addLast(10);
		list.addFirst(20);
		list.addLast(30);
		list.add(3, 40);
		assertEquals("20 10 40 30 ", list.toString());
		list.delete(4);
		assertEquals("20 10 40 ", list.toString());

		assertEquals(list.getTail().getPrevious().getData(), 10);
		assertEquals(list.getTail().getPrevious().getNext().getData(), 40);

		assertEquals(list.getHead().getNext().getNext().getData(), 40);

	}

	@Test
	public void testAddAtIndexOne() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(10);
		assertEquals("10 ", list.toString());

		list.addLast(20);
		assertEquals("10 20 ", list.toString());

		list.add(1, 30);
		assertEquals("30 10 20 ", list.toString());

		list.add(4, 40);
		assertEquals("30 10 20 40 ", list.toString());

		assertEquals(list.getHead().getNext().getNext().getData(), 20);
		assertEquals(list.getTail().getNext(), null);

		assertEquals(list.getHead().getNext().getPrevious().getData(), 30);
		assertEquals(list.getTail().getPrevious().getPrevious().getData(), 10);
	}
	
	@Test
	public void testDeleteFirstLastWhenOneNode(){
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(10);
		
		list.deleteFirst();
		assertEquals("", list.toString());
		assertEquals(0, list.size());
		
		DoublyLinkedList list1 = new DoublyLinkedList();
		list1.addFirst(10);
		list1.deleteLast();
		assertEquals("", list1.toString());
		assertEquals(0, list1.size());	
	}

}
