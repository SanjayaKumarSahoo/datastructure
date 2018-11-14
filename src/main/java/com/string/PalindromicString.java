package com.string;

public class PalindromicString {

    public static void main(String[] args) {
        System.out.println(isPalindromic("A man, a plan, a canal, Panama."));
        System.out.println(isPalindromic("Able was I, ere I saw Elba!"));
        System.out.println(isPalindromic("Ray a Ray"));
    }

    private static boolean isPalindromic(String first) {
        char[] charArray = first.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {

            if (!Character.isLetter(charArray[start])) {
                start++;
                continue;
            }

            if (!Character.isLetter(charArray[end])) {
                end--;
                continue;
            }

            if (Character.toLowerCase(charArray[start]) != Character.toLowerCase(charArray[end])) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}
