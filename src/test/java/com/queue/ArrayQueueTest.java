package com.queue;

import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest {

	@Test
	public void testEnqueue() {
		ArrayQueue arrayQueue = new ArrayQueue(1);
		arrayQueue.enQueue(100);
		Assert.assertEquals(1, arrayQueue.getSize());
		Assert.assertEquals(100, arrayQueue.deQueue().intValue());
		Assert.assertEquals(0, arrayQueue.getSize());

		arrayQueue = new ArrayQueue(2);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(101);
		Assert.assertEquals(2, arrayQueue.getSize());

		arrayQueue = new ArrayQueue(3);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(101);
		Assert.assertEquals(2, arrayQueue.getSize());
	}

	@Test
	public void testDequeue() {
		ArrayQueue arrayQueue = new ArrayQueue(3);

		arrayQueue.enQueue(100);
		Assert.assertEquals("100 ", arrayQueue.toString());

		arrayQueue.enQueue(101);
		Assert.assertEquals("100 101 ", arrayQueue.toString());

		arrayQueue.deQueue();
		Assert.assertEquals("101 ", arrayQueue.toString());

		arrayQueue.deQueue();
		Assert.assertEquals("", arrayQueue.toString());
		Assert.assertTrue(arrayQueue.isEmpty());

		arrayQueue.enQueue(1);
		arrayQueue.enQueue(2);
		arrayQueue.enQueue(3);
		Assert.assertEquals("1 2 3 ", arrayQueue.toString());
		Assert.assertEquals(3, arrayQueue.getSize());
	}

	@Test
	public void testQueueSize() {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(101);
		Assert.assertEquals(2, arrayQueue.getSize());
		arrayQueue.deQueue();
		arrayQueue.deQueue();
		Assert.assertEquals("", arrayQueue.toString());
		Assert.assertEquals(0, arrayQueue.getSize());

		arrayQueue.enQueue(1);
		arrayQueue.enQueue(2);
		arrayQueue.enQueue(3);
		Assert.assertEquals("1 2 3 ", arrayQueue.toString());
		Assert.assertEquals(3, arrayQueue.getSize());
	}

	@Test
	public void testQueueIsFull() {

		ArrayQueue arrayQueue = new ArrayQueue(1);
		arrayQueue.enQueue(100);
		Assert.assertTrue(arrayQueue.isFull());

		arrayQueue = new ArrayQueue(2);
		arrayQueue.enQueue(100);
		Assert.assertFalse(arrayQueue.isFull());

		arrayQueue = new ArrayQueue(2);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(101);
		Assert.assertTrue(arrayQueue.isFull());

		arrayQueue = new ArrayQueue(3);
		arrayQueue.enQueue(100);
		Assert.assertFalse(arrayQueue.isFull());

		arrayQueue = new ArrayQueue(3);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(100);
		arrayQueue.deQueue();
		Assert.assertFalse(arrayQueue.isFull());

		arrayQueue = new ArrayQueue(3);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(100);
		arrayQueue.enQueue(100);

		arrayQueue.deQueue();
		arrayQueue.deQueue();
		Assert.assertFalse(arrayQueue.isFull());
		Assert.assertEquals(1, arrayQueue.getSize());
	}

	@Test
	public void testQueueEmpty() {
		ArrayQueue arrayQueue = new ArrayQueue(1);
		Assert.assertTrue(arrayQueue.isEmpty());
		arrayQueue.enQueue(100);
		Assert.assertFalse(arrayQueue.isEmpty());
	}

}
