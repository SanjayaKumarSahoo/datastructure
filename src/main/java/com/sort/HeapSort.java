package com.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] input = {64, 25, 12, 22, 11, 13};
        Arrays.stream(sort(input))
                .forEach(System.out::println);
    }

    private static int[] sort(int[] input) {
        return input;
    }
}
