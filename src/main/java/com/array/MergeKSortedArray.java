package com.array;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedArray {

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 15};
        int[] array3 = {0, 9, 10, 11};

        List<int[]> input = new ArrayList<>();
        input.add(array1);
        input.add(array2);
        input.add(array3);

        int[] result = mergeKSortedArray(input);
        for (Integer element : result) {
            System.out.println(element);
        }
    }

    private static int[] mergeKSortedArray(List<int[]> sortedArrays) {

        if (sortedArrays == null || sortedArrays.size() < 1) {
            return null;
        }

        if (sortedArrays.size() == 1) {
            return sortedArrays.get(0);
        }

        int size = 0;
        for (int[] array : sortedArrays) {
            if (array != null && array.length > 0) {
                size = size + array.length;
            }
        }

        int k = 0;
        int[] r = mergeTwoSortedArray(sortedArrays.get(0), sortedArrays.get(1));

        for (int i = 2; i < sortedArrays.size(); i++) {
            r = mergeTwoSortedArray(r, sortedArrays.get(i));

        }
        return r;
    }

    private static int[] mergeTwoSortedArray(int[] array1, int[] array2) {

        if ((array1 == null || array1.length == 0) && (array2 == null || array2.length == 0)) {
            throw new IllegalArgumentException("Invalid data");
        }

        if (array1 == null || array1.length == 0) {
            return array2;
        }

        if (array2 == null || array2.length == 0) {
            return array1;
        }


        int[] result = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {

            if (array1[i] < array2[j]) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }

        if (i < array1.length) {
            for (int l = i; l < array1.length; l++) {
                result[k] = array1[l];
            }
        }

        if (j < array2.length) {
            for (int l = j; l < array2.length; l++) {
                result[k] = array2[l];
                k++;
            }
        }
        return result;
    }
}
