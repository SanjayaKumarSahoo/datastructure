package com.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {64, 25, 12, 22, 11, 97};
        Arrays.stream(sort(input))
                .forEach(System.out::println);
    }

    public static int[] sort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }
}
