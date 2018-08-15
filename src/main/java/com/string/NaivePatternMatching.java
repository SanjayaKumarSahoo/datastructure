package com.string;


public class NaivePatternMatching {

    // complexity O(mn)
    public static boolean naivePatternMatching(String input, String pattern) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("Input should not be empty");
        }

        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Pattern should not be empty");
        }

        char[] inputArray = input.toCharArray();
        char[] patternArray = pattern.toCharArray();

        boolean isMatch;
        for (int i = 0; i < inputArray.length; i++) {
            int start = i;
            isMatch = true;
            for (int j = 0; j < patternArray.length; j++) {
                if (inputArray[start] == patternArray[j]) {
                    start++;
                } else {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch == true) {
                return isMatch;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = naivePatternMatching("aabcdef", "aabcde");
        System.out.println(result);
    }
}
