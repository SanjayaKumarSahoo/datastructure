package com.primitive;

public class PalindromeDigit {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    // if the reverse of digit is same as the digit
    private static boolean isPalindrome(int digit) {
        return digit == reverse(digit);
    }

    private static int reverse(int digit) {
        int result = 0;
        int remaining = Math.abs(digit);
        while (remaining != 0) {
            result = result * 10 + remaining % 10;
            remaining = remaining / 10;
        }
        return result;
    }
}
