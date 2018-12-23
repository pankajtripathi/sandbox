package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));
    }

    private int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        // multiply current result and the num to get result for next num
        for (int i = 0; i < nums.length - 1; i++) {
            result[i + 1] = result[i] * nums[i];
        }

        int right = 1;
        // current result is right multiplied by result
        // right becomes right * num
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result ;
    }
}
