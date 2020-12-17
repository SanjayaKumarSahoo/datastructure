package com.array;

import java.util.Arrays;

public class OddEvenSeggregator {

    public static int[] oddEven(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("'Input data is empty");
        }

        int odd = 0;
        int even = input.length - 1;

        while (odd <= even) {

            if (input[odd] % 2 == 0 && input[even] % 2 != 0) {
                // swap odd/even
                int temp = input[odd];
                input[odd] = input[even];
                input[even] = temp;
            }

            if (input[odd] % 2 != 0) {
                odd++;
            }

            if (input[even] % 2 == 0) {
                even--;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 9, -1, -2};
        Arrays.stream(oddEven(data)).forEach(System.out::println);
    }
}
