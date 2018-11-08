package com.stack.problems;

import java.util.LinkedList;

public class MaxStack {

    private LinkedList<Element> storage;

    public MaxStack() {
        storage = new LinkedList<>();
    }

    public void push(int data) {
        storage.addFirst(new Element(data, Math.max(data, isEmpty() ? data : max())));
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public int pop() {
        return storage.removeFirst().value;
    }

    public int peek() {
        return storage.getFirst().value;
    }

    public int max() {
        return storage.getFirst().max;
    }

    public static class Element {
        final int value;
        final int max;

        public Element(int value, int max) {
            this.value = value;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack.max());
        System.out.println(stack.pop());
    }
}
