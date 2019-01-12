package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
* */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        System.out.println(new MaximumSubArray().getMaxArray(nums));
    }

    private int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    private List<Integer> getMaxArray(int[] nums) {
        LinkedList<Integer> maxEndingHere = new LinkedList<>();
        List<Integer> maxSoFar = new ArrayList<>();

        maxEndingHere.add(nums[0]);
        maxSoFar.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            maxEndingHere.addLast(nums[i]);
            int currentPlusMax = getSum(maxEndingHere);

            if (current >= currentPlusMax) {
                maxEndingHere.clear();
                maxEndingHere.add(nums[i]);
            }

            if (getSum(maxEndingHere) > getSum(maxSoFar)) {
                maxSoFar.clear();
                maxSoFar = new ArrayList<>(maxEndingHere);
            }

            System.out.println("Max Ending - " + i + " " + maxEndingHere);
            System.out.println("Max So Far - " + i + " " + maxSoFar);
            System.out.println();
        }

        return maxSoFar;
    }

    private int getSum(List<Integer> list) {
        int sum = 0;
        for (int val: list) {
            sum += val;
        }

        return sum;
    }
}
