package com.array;

import java.util.Arrays;

public class ArrayProblems {

    // Problem : print even number first in any array provided
    public static int[] evenFirst(int[] input) {

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

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6};
        evenFirst(data);
        Arrays.stream(evenFirst(data))
                .forEach(x -> System.out.println(x));
        ;
    }
}
