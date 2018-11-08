package com.stack.problems;

import java.util.Stack;

public class RPNExpression {

    public static void main(String[] args) {
        String input = "3,4,+,2,*,1,+";
        System.out.println(eval(input));
    }

    // It is of the form“A,B,o" where A and B are RPN expressions and o is one of  +,-,X,/
    private static int eval(String input) {

        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("Input is not valid.");
        }

        boolean isNegative = input.charAt(0) == '-';
        String[] splitData = input.split(",");

        Stack<Integer> stack = new Stack<>();
        int idx = isNegative ? 1 : 0;
        while (idx < splitData.length) {
            if (splitData[idx].length() == 1 && !Character.isDigit(splitData[idx].charAt(0))) {
                int x = stack.pop();
                int y = stack.pop();
                switch (splitData[idx].charAt(0)) {
                    case '+':
                        stack.push(x + y);
                        break;
                    case '-':
                        stack.push(x - y);
                        break;
                    case '*':
                        stack.push(x * y);
                        break;
                    case '/':
                        stack.push(x / y);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid token");
                }
            } else {
                // its a digit
                stack.push(Integer.parseInt(splitData[idx]));
            }
            idx++;
        }
        return isNegative ? Integer.parseInt("-" + stack.pop()) : stack.pop();
    }
}