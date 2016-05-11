package com.queue;

// circular array implementation of queue
public class ArrayQueue {

	int front = -1;
	int rear = -1;
	Integer array[];
	final int capacity;

	public ArrayQueue(int capacity) {
		array = new Integer[capacity];
		this.capacity = capacity;
	}

	public void enQueue(int data) {
		if (isFull()) {
			throw new RuntimeException("Queue overflow");
		} else {
			rear = (rear + 1) % capacity;
			array[rear] = data;
			if (front == -1) {
				front = rear;
			}
		}
	}

	public Integer deQueue() {
		Integer data = null;
		if (isEmpty()) {
			throw new RuntimeException("Queue empty");
		} else {
			if (getSize() == 1) {
				data = array[front];
				// nullifying element
				array[front] = null;
				front = -1;
				rear = -1;
			} else {
				data = array[front];
				// nullifying element
				array[front] = null;
				if (front == rear) {
					front = rear - 1;
				} else {
					front = (front + 1) % capacity;
				}
			}
		}
		return data;
	}

	public int getSize() {
		if (isFull()) {
			return capacity;
		}

		if (isEmpty()) {
			return 0;
		}

		return ((capacity - front + rear + 1) % capacity);
	}

	public boolean isFull() {
		return (rear + 1) % capacity == front;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Integer data : array) {
			if (data != null) {
				builder.append(data + " ");
			}
		}
		return builder.toString();
	}
}
