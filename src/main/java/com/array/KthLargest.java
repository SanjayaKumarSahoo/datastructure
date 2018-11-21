package com.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {


    public static void main(String[] args) {
        int[] data = {1, 2, -1, 4, 3};
        System.out.println(findKthLargest(data, 2));
    }

    private static int findKthLargest(int[] data, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < data.length; i++) {
            maxHeap.add(data[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
