package com.array;

public class IncrementArbitaryInteger {

    public static void main(String[] args) {
        int[] input = {1, 2, 8};
        int[] result = increment(input, 12);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] increment(int[] input, int m) {
        int carry = 0;
        for (int i = input.length - 1; i >= 0; i--) {

            int sum;
            if (i == input.length - 1) {
                sum = input[i] + m;
            } else {
                sum = carry + input[i];
            }

            int remainder = sum % 10;
            if (remainder == sum) {
                input[i] = sum;
            } else {
                carry = sum / 10;

                if (i == 0) {
                    input[i] = sum;
                } else {
                    input[i] = remainder;
                }
            }
        }
        // if carry is
        return input;
    }
}
