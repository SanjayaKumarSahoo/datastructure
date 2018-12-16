package com.array;

public class FindAllSubArray {

    public static void main(String[] args) {
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8};
        findAllSubArray(d);
    }

    private static void findAllSubArray(int[] array) {
        int n = array.length;
        // Pick starting point
        for (int i = 0; i < n; i++) {
            // Pick ending point
            for (int j = i; j < n; j++) {
                System.out.println();
                // Print sub array between current starting and ending points
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k] + " ");
                }
            }
        }
    }
}
