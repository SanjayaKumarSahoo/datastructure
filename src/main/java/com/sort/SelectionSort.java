package com.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] input = {64, 25, 12, 22, 11, 13};
        Arrays.stream(sort(input))
                .forEach(System.out::println);
    }

    // complexity O(n2)
    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int idx = findMinIdx(i, data);
            // swap idx with i
            int temp = data[i];
            data[i] = data[idx];
            data[idx] = temp;
        }
        return data;
    }

    private static int findMinIdx(int loc, int[] data) {
        int min = data[loc];
        int idx = loc;
        for (int i = loc + 1; i < data.length; i++) {
            if (min < data[i]) {
                min = data[i];
                idx = i;
            }
        }
        return idx;
    }
}