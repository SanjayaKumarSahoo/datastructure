package com.string;

public class PalindromicString {

    public static void main(String[] args) {
        System.out.println(isPalindromic("ABCDCBA"));
    }

    private static boolean isPalindromic(String first) {
        char[] charArray = first.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
