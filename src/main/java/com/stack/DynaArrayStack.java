package com.stack;

public class DynaArrayStack {

	private int capacity;
	private Integer array[];
	private int top;

	public DynaArrayStack(int capacity) {
		this.capacity = capacity;
		array = new Integer[capacity];
		top = -1;
	}

	public void push(int data) {
		if (isStackFull()) {
			doubleStack();
		}
		array[++top] = data;
	}

	public void doubleStack() {
		Integer newArray[] = new Integer[capacity * 2];
		System.arraycopy(array, 0, newArray, 0, capacity);
		capacity = capacity * 2;
		array = newArray;
	}

	public Integer pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack undeflow");
		}
		int data = array[top];
		array[top] = null;
		top = top - 1;
		return data;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isStackFull() {
		return top == capacity - 1;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= top; i++) {
			builder.append(array[i] + " ");
		}
		return builder.toString();
	}

}
