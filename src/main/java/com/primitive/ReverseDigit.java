package com.primitive;

public class ReverseDigit {

    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }

    private static int reverse(int val) {
        int remainingValue = Math.abs(val);
        int result = 0;
        while (remainingValue != 0) {
            result = result * 10 + remainingValue % 10;
            remainingValue = remainingValue / 10;
        }
        return val < 0 ? -result : result;
    }
}
