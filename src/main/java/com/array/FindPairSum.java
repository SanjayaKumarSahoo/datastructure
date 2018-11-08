package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairSum {

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 5, 3, 1, 0};
        System.out.println(pairSum(input, 2));
    }

    private static List<List<Integer>> pairSum(int[] A, int sum) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int diff = sum - A[i];
            if (set.contains(diff)) {
                result.add(Arrays.asList(A[i], diff));
            }
            set.add(A[i]);
        }
        return result;
    }
}
