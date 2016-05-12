package com.queue;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedListBasedQueueTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testEnqueue() {
		LinkedListBasedQueue queue = new LinkedListBasedQueue();
		queue.enQueue(100);
		Assert.assertEquals(1, queue.getSize());
		Assert.assertEquals(100, queue.deQueue().intValue());
		Assert.assertEquals(0, queue.getSize());

		queue = new LinkedListBasedQueue();
		queue.enQueue(100);
		queue.enQueue(101);
		Assert.assertEquals(2, queue.getSize());

		queue = new LinkedListBasedQueue();
		queue.enQueue(100);
		queue.enQueue(101);
		Assert.assertEquals(2, queue.getSize());
	}

	@Test
	public void testDequeue() {
		LinkedListBasedQueue queue = new LinkedListBasedQueue();

		queue.enQueue(100);
		Assert.assertEquals("100 ", queue.toString());

		queue.enQueue(101);
		Assert.assertEquals("100 101 ", queue.toString());

		queue.deQueue();
		Assert.assertEquals("101 ", queue.toString());

		queue.deQueue();
		Assert.assertEquals("", queue.toString());
		Assert.assertTrue(queue.isEmpty());

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		Assert.assertEquals("1 2 3 ", queue.toString());
		Assert.assertEquals(3, queue.getSize());
	}

	@Test
	public void testQueueSize() {
		LinkedListBasedQueue queue = new LinkedListBasedQueue();
		queue.enQueue(100);
		queue.enQueue(101);
		Assert.assertEquals(2, queue.getSize());
		queue.deQueue();
		queue.deQueue();
		Assert.assertEquals("", queue.toString());
		Assert.assertEquals(0, queue.getSize());

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		Assert.assertEquals("1 2 3 ", queue.toString());
		Assert.assertEquals(3, queue.getSize());
	}

	@Test
	public void testQueueEmpty() {
		LinkedListBasedQueue queue = new LinkedListBasedQueue();
		Assert.assertTrue(queue.isEmpty());
		queue.enQueue(100);
		Assert.assertFalse(queue.isEmpty());
	}

	@Test
	public void queueThrowsRuntimeExceptionWhenDequeCallInEmptyQueue() {
		LinkedListBasedQueue queue = new LinkedListBasedQueue();
		exception.expect(RuntimeException.class);
		queue.deQueue();
	}

}
