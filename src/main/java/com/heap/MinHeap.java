package com.heap;

import java.util.Arrays;

// Array implementation of min heap
public class MinHeap {

    private Integer[] data;
    int size = 0;
    int capacity;

    public MinHeap(int capacity) {
        this.data = new Integer[capacity];
        this.capacity = capacity;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChild(int index) {
        return data[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return data[getRightChild(index)];
    }

    private int getParent(int index) {
        return data[getParent(index)];
    }


    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is overflow");
        }
        return data[0];
    }

    public void add(int element) {
        ensureExtraCapacity();
        data[size] = element;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {

    }

    public int poll(int element) {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        int item = data[0];
        data[0] = data[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {

    }


    public void ensureExtraCapacity() {
        if (size == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity = capacity * 2;
        }
    }


    public int getMin() {
        return -1;
    }

    public int extractMin() {
        return -1;
    }
}
