package arrays;

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
        int[] nums = {-2, 1};
        System.out.println(new MaximumSubArray().maxSubArray(nums));
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
}
