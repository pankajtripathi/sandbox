package sorting;

import java.util.Arrays;

public class HeapSort {
    int N;

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 12, 0, 9};
        new HeapSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void sort(int[] nums) {
        heapify(nums);
        for (int i = N; i > 0; i--) {
            swap(nums, i, 0);
            N = N - 1;
            maxheap(nums, 0);
        }
    }

    private void heapify(int[] nums) {
        N = nums.length - 1;

        for (int i = N/2; i >= 0; i--) {
            maxheap(nums, i);
        }
    }

    private void maxheap(int[] nums, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;

        if (left < nums.length && nums[left] > nums[max])
            max = left;

        if (right < nums.length && nums[right] > nums[max])
            max = right;

        if (max != i) {
            swap(nums, max, i);
            maxheap(nums, max);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}