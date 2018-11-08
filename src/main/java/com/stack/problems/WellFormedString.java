package com.stack.problems;

import java.util.Stack;

public class WellFormedString {
    public static void main(String[] args) {
        System.out.println(isWellFormed("([]){()}"));
        System.out.println(isWellFormed("[()[]|()()|]"));
        System.out.println(isWellFormed("[]"));
        System.out.println(isWellFormed("[()[]{()()}]"));
        System.out.println(isWellFormed("{)"));
        System.out.println(isWellFormed("[()[]{()()"));

    }

    // TEST A STRING OVER FOR WELL-FORMEDNESS  {,},[,],(,)
    public static boolean isWellFormed(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '(':
                    stack.push(charArray[i]);
                    break;
                case '{':
                    stack.push(charArray[i]);
                    break;
                case '[':
                    stack.push(charArray[i]);
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
