package com.array;

public class DeleteDuplicateSortedArray {

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 5, 7, 11, 11, 11, 13};
        int n = removeDuplicates(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static int removeDuplicates(int arr[]) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] != arr[i + 1])
                arr[j++] = arr[i];

        arr[j++] = arr[arr.length - 1];

        return j;
    }
}
