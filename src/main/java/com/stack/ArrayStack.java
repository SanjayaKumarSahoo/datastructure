package com.stack;

public class ArrayStack {

	private Integer array[];
	private int top;
	private final int capacity;

	public ArrayStack(int capacity) {
		this.capacity = capacity;
		array = new Integer[capacity];
		top = -1;
	}

	public void push(int data) {
		if (isStackFull()) {
			throw new RuntimeException("Stack is overflow");
		} else {
			array[++top] = data;
		}
	}

	public Integer pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is underflow");
		} else {
			int i = array[top];
			array[top] = null;
			top--;
			return i;
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isStackFull() {
		return capacity - 1 == top;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= top; i++) {
			builder.append(array[i] + " ");
		}
		return builder.toString();
	}
}
