package com.array;

import java.util.HashSet;
import java.util.Set;

public class FindTripletSum {

    public static void main(String[] args) {
        int[] A = {12, 3, 4, 1, 6, 9};
        int[] result = findTripletSum(A, 8);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] findTripletSum(int[] A, int sum) {

        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[3];
        for (int i = 0; i < A.length; i++) {
            int currentSum = sum - A[i];
            Set<Integer> set = new HashSet();
            for (int j = i + 1; j < A.length; j++) {
                if (set.contains(currentSum - A[j])) {
                    result[0] = A[i];
                    result[1] = A[j];
                    result[2] = currentSum - A[j];
                    return result;
                }
                set.add(A[j]);
            }
        }
        return result;
    }


    private static int[] findTripletSumBruteForce(int[] A, int sum) {

        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[3];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] + A[j] + A[k] == sum) {
                        result[0] = A[i];
                        result[1] = A[j];
                        result[2] = A[k];
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
