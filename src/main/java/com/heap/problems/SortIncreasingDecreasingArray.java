package com.heap.problems;

import com.array.MergeKSortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortIncreasingDecreasingArray {

    public static void main(String[] args) {
        int[] input = {57, 131, 493, 294, 221, 339, 418, 452, 442, 190};
        int[] result = sortKIncreasingDecreasingArray(input);
        for (Integer element : result) {
            System.out.println(element);
        }
    }

    private static int[] sortKIncreasingDecreasingArray(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return MergeKSortedArray.mergeKSortedArray(findSortedArrays(input));
    }


    private static void reverse(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }

    private static List<int[]> findSortedArrays(int[] input) {

        List<int[]> sortedArrays = new ArrayList<>();
        SubArrayType subArrayType = SubArrayType.INCREASING;
        int startIdx = 0;

        for (int i = 1; i <= input.length; i++) {
            if (i == input.length
                    || (input[i - 1] < input[i] && subArrayType == SubArrayType.DECREASING)
                    || (input[i - 1] >= input[i] && subArrayType == SubArrayType.INCREASING)) {

                int[] subArray = Arrays.copyOfRange(input, startIdx, i);
                if (subArrayType == SubArrayType.DECREASING) {
                    reverse(subArray);
                }
                sortedArrays.add(subArray);
                startIdx = i;
                subArrayType = (subArrayType == SubArrayType.INCREASING
                        ? SubArrayType.DECREASING
                        : SubArrayType.INCREASING);
            }
        }
        return sortedArrays;
    }

    private static enum SubArrayType {INCREASING, DECREASING}
}
