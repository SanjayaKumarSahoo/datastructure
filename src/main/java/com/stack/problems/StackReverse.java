package com.stack.problems;

import java.util.Stack;

public class StackReverse {

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(4);
        input.push(3);
        input.push(2);
        input.push(1);
        reverse(input);
        while (!input.isEmpty()) {
            System.out.println(input.pop());
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.size() > 0) {
            int element = stack.peek();
            stack.pop();
            reverse(stack);
            insertAtLast(stack, element);
        }
    }

    private static void insertAtLast(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            int data = stack.peek();
            stack.pop();
            insertAtLast(stack, element);
            stack.push(data);

        }
    }
}
