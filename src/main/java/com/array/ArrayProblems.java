package com.array;

import java.util.Arrays;

public class ArrayProblems {

    // Problem : print even number first in any array provided
    public static int[] evenOdd(int[] input) {

        if (input.length == 0) {
            return input;
        }
        int idx = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] % 2 == 0) {
                int data = input[i];
                for (int j = i; j > idx; j--) {
                    input[j] = input[j - 1];
                }
                input[idx] = data;
                idx++;
            }
        }
        return input;
    }


    // complexity O(n)
    public static int[] reverse(int[] input) {
        if (input.length == 0) {
            return input;
        }
        int start = 0;
        int end = input.length - 1;
        while (start <= end) {
            // swap input[start] with input[end]
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            // increase start and decrease end
            start++;
            end--;
        }
        return input;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 3, 4, 5, 6, 1};
        Arrays.stream(evenOdd(data1))
                .forEach(x -> System.out.println(x));

        System.out.println("=== Array Reverse ===");
        int[] data2 = {7, 8, 9, 10};
        Arrays.stream(reverse(data2))
                .forEach(x -> System.out.println(x));
    }
}
