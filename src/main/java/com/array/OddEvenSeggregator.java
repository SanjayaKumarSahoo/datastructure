package com.array;

import java.util.Arrays;

public class OddEvenSeggregator {

    public static int[] oddEven(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("'Input data is empty");
        }

        int start = 0;
        int end = input.length - 1;

        while (start <= end) {

            if (input[start] % 2 == 0 && input[end] % 2 != 0) {
                // swap odd/even
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
            }

            if (input[start] % 2 != 0) {
                start++;
            }

            if (input[end] % 2 == 0) {
                end--;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 9, -1, -2};
        Arrays.stream(oddEven(data)).forEach(System.out::println);
    }
}
