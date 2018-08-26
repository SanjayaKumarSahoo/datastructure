package com.array;

import java.util.Stack;

public class GreaterElementArray {

    public static void printNextGreaterElement(Integer[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException("Input is empty");
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(input[0]);

        for (int i = 1; i < input.length; i++) {

            if (stack.empty()) {
                stack.push(input[i]);
                continue;
            }
            while (stack.empty() == false && stack.peek() < input[i]) {
                System.out.println(stack.peek() + " -> " + input[i]);
                stack.pop();
            }
            stack.push(input[i]);
        }

        while (stack.empty() == false) {
            System.out.println(stack.peek() + " -> X");
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Integer[] data = {1, 5, 2, 7, 9, 3};
        printNextGreaterElement(data);
    }
}
