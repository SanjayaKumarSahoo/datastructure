package com.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    public static int kthSmallest(int[] data, int k) {
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, -1, 4, 3};
        System.out.println(findKthSmallest(data, 3));
    }

    private static int findKthSmallest(int[] data, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < data.length; i++) {
            minHeap.add(data[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
