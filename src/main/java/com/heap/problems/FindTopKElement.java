package com.heap.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindTopKElement {

    public static void main(String[] args) {
        int[] data = {3, 4, 6, 5, 2, 1};
        System.out.println(findTopK(data, 2));
    }

    private static List<Integer> findTopK(int[] input, int top) {

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

        for (int i = 0; i < input.length; i++) {
            minHeap.add(input[i]);
            if (minHeap.size() > top) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }
}
