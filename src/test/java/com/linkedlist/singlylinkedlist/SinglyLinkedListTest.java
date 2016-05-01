package com.linkedlist.singlylinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SinglyLinkedListTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testAddFirst() {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.addFirst(10);
		linkedList.addFirst(9);
		linkedList.addFirst(8);
		linkedList.addFirst(7);
		assertEquals("7 8 9 10 ", linkedList.toString());
		assertEquals(linkedList.getHead().getData(), 7);
		assertEquals(linkedList.getTail().getData(), 10);
	}

	@Test
	public void testAddLast() {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.addLast(8);
		linkedList.addLast(9);
		linkedList.addLast(10);
		assertEquals("8 9 10 ", linkedList.toString());
		assertEquals(linkedList.getHead().getData(), 8);
		assertEquals(linkedList.getTail().getData(), 10);
	}

	@Test
	public void testAddToListByAnyLocation() {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.add(1, 101);
		linkedList.add(2, 102);
		linkedList.add(3, 103);
		linkedList.add(4, 104);
		linkedList.add(3, 100000);
		linkedList.add(2, 100001);
		assertEquals("101 100001 102 100000 103 104 ", linkedList.toString());
		assertEquals(linkedList.getHead().getData(), 101);
		assertEquals(linkedList.getTail().getData(), 104);
	}

	@Test
	public void testDeleteFirst() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);
		assertEquals("3 2 1 4 ", list.toString());

		list.deleteFirst();
		assertEquals("2 1 4 ", list.toString());

		list.deleteFirst();
		list.deleteFirst();
		list.deleteFirst();
		Assert.assertTrue(list.size() == 0);
	}

	@Test
	public void testDeleteFirstWhenNoElementThere() {
		SinglyLinkedList list = new SinglyLinkedList();
		exception.expect(RuntimeException.class);
		list.deleteFirst();
	}

	@Test
	public void testDeleteLast() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);
		assertEquals("3 2 1 4 ", list.toString());

		list.deleteLast();
		assertEquals("3 2 1 ", list.toString());

		list.deleteLast();
		assertEquals("3 2 ", list.toString());

		list.deleteLast();
		assertEquals("3 ", list.toString());

		list.deleteLast();
		assertTrue(list.size() == 0);
	}

	@Test
	public void testDeleteByPosition() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);
		assertEquals("3 2 1 4 ", list.toString());

		list.delete(1);
		assertEquals("2 1 4 ", list.toString());

		list.delete(2);
		assertEquals("2 4 ", list.toString());

		list.delete(2);
		assertEquals("2 ", list.toString());

		list.delete(1);
		assertTrue(list.size() == 0);

		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.addLast(10);
		list1.addLast(20);
		list1.addLast(30);
		list1.addLast(40);
		list1.addLast(50);
		list1.addLast(60);
		assertEquals("10 20 30 40 50 60 ", list1.toString());

		list1.delete(4);
		assertEquals("10 20 30 50 60 ", list1.toString());

		assertEquals(list1.getHead().getData(), 10);
		assertEquals(list1.getTail().getData(), 60);
	}

	@Test
	public void testAddAtIndexOne() {
		SinglyLinkedList list = new SinglyLinkedList();
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
	}
	
	@Test
	public void testDeleteFirstLastWhenOneNode(){
		SinglyLinkedList list = new SinglyLinkedList();
		list.addFirst(10);
		
		list.deleteFirst();
		assertEquals("", list.toString());
		assertEquals(0, list.size());
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.addFirst(10);
		list1.deleteLast();
		assertEquals("", list1.toString());
		assertEquals(0, list1.size());
		
	}

}
