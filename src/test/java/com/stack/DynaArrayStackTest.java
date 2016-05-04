package com.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DynaArrayStackTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testPush() {
		DynaArrayStack stack = new DynaArrayStack(2);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals("1 2 3 4 5 ", stack.toString());
	}

	@Test
	public void testPop() {
		DynaArrayStack stack = new DynaArrayStack(2);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals("1 2 3 4 5 ", stack.toString());

		assertEquals(5, stack.pop().intValue());
		assertEquals(4, stack.pop().intValue());
		assertEquals("1 2 3 ", stack.toString());
	}

	@Test
	public void testSize() {
		DynaArrayStack stack = new DynaArrayStack(2);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals(5, stack.size());

		stack.pop();
		stack.pop();
		assertEquals(3, stack.size());

		stack.push(12);
		assertEquals(4, stack.size());
		assertEquals("1 2 3 12 ", stack.toString());
	}

	@Test
	public void testStackIsEmpty() {
		DynaArrayStack stack = new DynaArrayStack(1);
		assertTrue(stack.isEmpty());
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testStackIsFull() {
		DynaArrayStack stack = new DynaArrayStack(1);
		stack.push(1);
		assertTrue(stack.isStackFull());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testStackUnderFlow() {
		DynaArrayStack stack = new DynaArrayStack(2);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		exception.expect(RuntimeException.class);
		stack.pop();
	}
}
