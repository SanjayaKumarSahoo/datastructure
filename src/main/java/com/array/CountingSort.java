package com.array;


import java.util.HashMap;
import java.util.Map;

public class CountingSort {

    // assuming we have distinct number of elements
    public static int[] sort(int[] data) {
        if (data.length == 0) {
            throw new IllegalArgumentException("Input array is empty");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (map.get(data[i]) == null) {
                map.put(data[i], 1);
            } else {
                int count = map.get(data[i]);
                map.put(data[i], count + 1);
            }
        }

        int j = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                data[j] = entry.getKey();
                j++;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 1, 1, 2, 3, 3, 2, 1,};
        sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
