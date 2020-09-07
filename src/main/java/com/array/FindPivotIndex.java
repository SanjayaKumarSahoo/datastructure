package com.array;

//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
public class FindPivotIndex {

    private static int findPivotIndex(int[] nums) {

        if (nums.length == 0) {
            throw new RuntimeException("Invalid input");
        }

        if (nums.length == 1) {
            return -1;
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum = totalSum + num;
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                continue;
            }
            leftSum = leftSum + nums[i - 1];
            rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = findPivotIndex(nums);
        System.out.println(result);
    }
}
