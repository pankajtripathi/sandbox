package arrays;

import java.util.Arrays;

/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
* */
public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        new WiggleSort().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));



    }

    private void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // if even index and prev is smaller than current then swap
            if (i % 2 == 0) {
                if (i > 0 && nums[i - 1] < nums[i])
                    swap(nums, i - 1, i);
            } else {
                // odd index and prev is greater than current then swap
                if (i > 0 && nums[i - 1] > nums[i])
                    swap(nums, i - 1, i);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
