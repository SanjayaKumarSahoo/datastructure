package com.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArrayStackTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	
	@Test
	public void testPush() {
		ArrayStack stack = new ArrayStack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals("1 2 3 4 5 ", stack.toString());
	}

	@Test
	public void testPop() {
		ArrayStack stack = new ArrayStack(10);
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
		ArrayStack stack = new ArrayStack(10);
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
		ArrayStack stack = new ArrayStack(10);
		assertTrue(stack.isEmpty());
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testStackIsFull() {
		ArrayStack stack = new ArrayStack(1);
		stack.push(1);
		assertTrue(stack.isStackFull());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testStackOverFlow(){
		ArrayStack stack = new ArrayStack(2);
		stack.push(1);
		stack.push(2);
		exception.expect(RuntimeException.class);
		stack.push(3);		
	}
	
	@Test
	public void testStackUnderFlow(){
		ArrayStack stack = new ArrayStack(2);
		stack.push(1);
		stack.push(2);		
		stack.pop();
		stack.pop();
		exception.expect(RuntimeException.class);
		stack.pop();		
	}
}
