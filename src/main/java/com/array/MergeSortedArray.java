package com.array;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] A1 = {1, 3, 4, 5};
        int[] A2 = {2, 4, 6, 8};
        int[] result = mergeSortedArray(A1, A2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] mergeSortedArray(int[] A1, int[] A2) {

        int size1 = A1.length;
        int size2 = A2.length;

        if (size1 == 0 && size2 == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (size1 == 0) {
            return A2;
        }

        if (size2 == 0) {
            return A1;
        }

        int[] result = new int[size1 + size2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < size1 && j < size2) {
            if (A1[i] < A2[j]) {
                result[k++] = A1[i++];
            } else {
                result[k++] = A2[j++];
            }
        }
        while (i < size1) {
            result[k++] = A1[i++];
        }

        while (j < size2) {
            result[k++] = A2[j++];
        }
        return result;
    }
}
